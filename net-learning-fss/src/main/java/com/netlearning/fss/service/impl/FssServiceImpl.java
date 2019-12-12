package com.netlearning.fss.service.impl;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.AccessToken;
import com.netlearning.framework.domain.fss.FileRecord;
import com.netlearning.framework.em.FileConstants;
import com.netlearning.framework.domain.fss.response.AccessTokenResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.fss.fastdfs.FastDFSFile;
import com.netlearning.fss.fastdfs.FileClientPool;
import com.netlearning.fss.fastdfs.FileUploadResult;
import com.netlearning.fss.mapper.AccessTokenMapper;
import com.netlearning.fss.mapper.FileRecordMapper;
import com.netlearning.fss.mapper.FileTypeMapper;
import com.netlearning.fss.service.FssService;
import org.csource.common.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/4 14:23
 */
@Service
public class FssServiceImpl implements FssService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected SequenceService sequenceService;
    public String createGeneralCode() {
        return String.valueOf(this.sequenceService.nextValue(null));
    }
    @Value("{fss_file_path}")
    private String FILE_PATH ;
    @Autowired
    private AccessTokenMapper accessTokenMapper;
    @Autowired
    private FileRecordMapper fileRecordMapper;
    @Autowired
    private FileTypeMapper fileTypeMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public CommonResult upload(MultipartFile[] files, String userId, String tokenKey) {
        //校验文件上传格式
        //检验userID
        AccessToken accessToken = new AccessToken();
        accessToken.setUniqueId(tokenKey);
        accessToken.setType(FileConstants.FileRequestType.UPLOAD.getCode());
        List<AccessTokenResult> accessTokenResults =  accessTokenMapper.get(accessToken);
        if (CollectionUtils.isEmpty(accessTokenResults)){
            CommonResult.fail(ExceptionCode.FssCode.CODE002.code,ExceptionCode.FssCode.CODE002.message);
        }

        //获取上传的文件数组
        //创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(5, 5,0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler(){
                    @Override
                    public void rejectedExecution(Runnable r,ThreadPoolExecutor executor) {
                        throw new RejectedExecutionException("自定义拒绝策略： " + r.toString() + " rejected from "
                        );
                    }
                });
        //执行上传
        for (MultipartFile file : files) {

            Thread thread=new Thread(){
                @Override
                public void run() {
                    try {
                        uploadFile(file,userId);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(thread);
        }
        return CommonResult.success(true);
    }
    private void uploadFile(MultipartFile multipartFile,String userId) throws IOException {

        byte[] bytes = multipartFile.getBytes();
        String ext = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."),multipartFile.getOriginalFilename().length());
        FastDFSFile file = new FastDFSFile(bytes, ext);
        NameValuePair[] meta_list = new NameValuePair[4];
        meta_list[0] = new NameValuePair("fileName", multipartFile.getName());
        meta_list[1] = new NameValuePair("fileLength", String.valueOf(bytes.length));
        meta_list[2] = new NameValuePair("fileExt", ext);
        meta_list[3] = new NameValuePair("fileAuthor", userId);
        FileUploadResult fileUploadResult = FileClientPool.upload(file, null);

        //将数据写入数据库
//        FileRecord fileRecord = new FileRecord();
//        fileRecordMapper.insert(fileRecord);
        System.out.println(fileUploadResult);
    }
}

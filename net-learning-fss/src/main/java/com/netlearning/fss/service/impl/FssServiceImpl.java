package com.netlearning.fss.service.impl;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.AccessToken;
import com.netlearning.framework.domain.fss.FileRecord;
import com.netlearning.framework.em.FileConstants;
import com.netlearning.framework.domain.fss.response.AccessTokenResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.SnowflakeIdWorker;
import com.netlearning.framework.utils.StringUtils;
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
import java.util.Date;
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

    private final static SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1, 1);
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
        //校验
        if (!StringUtils.isEmpty(userId)){
            return CommonResult.fail(ExceptionCode.FssCode.CODE003.code,ExceptionCode.FssCode.CODE003.message);
        }
        if (!StringUtils.isEmpty(tokenKey)){
            return CommonResult.fail(ExceptionCode.FssCode.CODE004.code,ExceptionCode.FssCode.CODE004.message);
        }
        if (files.length <= 0){
            return CommonResult.fail(ExceptionCode.FssCode.CODE005.code,ExceptionCode.FssCode.CODE005.message);
        }

        AccessToken accessToken = new AccessToken();
        accessToken.setUniqueId(tokenKey);
        accessToken.setType(FileConstants.FileRequestType.UPLOAD.getCode());
        List<AccessTokenResult> accessTokenResults =  accessTokenMapper.get(accessToken);
        if (CollectionUtils.isEmpty(accessTokenResults)){
            return CommonResult.fail(ExceptionCode.FssCode.CODE002.code,ExceptionCode.FssCode.CODE002.message);
        }

        //获取上传的文件数组
        //创建线程池
//        ExecutorService executorService = new ThreadPoolExecutor(5, 5,0L, TimeUnit.MILLISECONDS,
//                new SynchronousQueue<Runnable>(),
//                Executors.defaultThreadFactory(),
//                new RejectedExecutionHandler(){
//                    @Override
//                    public void rejectedExecution(Runnable r,ThreadPoolExecutor executor) {
//                        throw new RejectedExecutionException("自定义拒绝策略： " + r.toString() + " rejected from "
//                        );
//                    }
//                });
        ExecutorService executorService = Executors.newCachedThreadPool();
        //执行上传
        for (MultipartFile file : files) {

            Thread thread=new Thread(){
                @Override
                public void run() {
                    try {
                        uploadFile(file,userId,tokenKey);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(thread);
        }
        return CommonResult.success(true);
    }

    @Override
    public CommonResult applyUploadToken(String userId, String type) {
        //校验
        if (!StringUtils.isEmpty(userId)){
            return CommonResult.fail(ExceptionCode.FssCode.CODE003.code,ExceptionCode.FssCode.CODE003.message);
        }
        if (!StringUtils.isEmpty(type)){
            return CommonResult.fail(ExceptionCode.FssCode.CODE004.code,ExceptionCode.FssCode.CODE004.message);
        }

        if(!FileConstants.FileRequestType.FileTypeList().contains(type)){
            return CommonResult.fail(ExceptionCode.FssCode.CODE006.code,ExceptionCode.FssCode.CODE006.message);
        }
        AccessToken accessToken  = new AccessToken();
        accessToken.setType(type);
        accessTokenMapper.insert(accessToken);

        return null;
    }

    private FileRecord uploadFile(MultipartFile multipartFile,String userId,String tokenKey) throws IOException {

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
        FileRecord fileRecord = new FileRecord();
        fileRecord.setId(this.createGeneralCode());
//        fileRecord.setId(String.valueOf(idWorker.nextId()));
        fileRecord.setContentType(multipartFile.getContentType());
        fileRecord.setCteateTime(new Date());
        fileRecord.setGroupName(fileUploadResult.getGroupName());
        fileRecord.setFileAbsolutePath(fileUploadResult.getFileAbsolutePath());
        fileRecord.setRemoteFileName(fileUploadResult.getRemoteFileName());
        fileRecord.setUserId(userId);
        fileRecord.setUniqueId(tokenKey);
        fileRecord.setOrigFileName(multipartFile.getOriginalFilename());
        fileRecord.setFileSize(multipartFile.getSize());
        fileRecordMapper.insert(fileRecord);
        System.out.println(fileUploadResult);
        return fileRecord;
    }
}

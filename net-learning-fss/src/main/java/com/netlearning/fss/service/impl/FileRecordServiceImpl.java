package com.netlearning.fss.service.impl;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.fss.FileRecord;
import com.netlearning.framework.domain.fss.FileRecordImages;
import com.netlearning.framework.domain.fss.FileRecordResources;
import com.netlearning.framework.domain.fss.param.FileRecordApplyTokenParam;
import com.netlearning.framework.domain.fss.param.FileRecordDowmloadParam;
import com.netlearning.framework.domain.fss.param.FileRecordRemoveParam;
import com.netlearning.framework.domain.fss.param.FileRecordUploadParam;
import com.netlearning.framework.em.FileConstants;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.fss.fastdfs.FastDFSFile;
import com.netlearning.fss.fastdfs.FileClientPool;
import com.netlearning.fss.fastdfs.FileUploadResult;
import com.netlearning.fss.mapper.FileRecordImagesMapper;
import com.netlearning.fss.mapper.FileRecordMapper;
import com.netlearning.fss.mapper.FileRecordResourcesMapper;
import com.netlearning.fss.service.FileRecordService;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/28 23:19
 */
@Service
public class FileRecordServiceImpl implements FileRecordService {
    @Autowired
    private FileRecordMapper fileRecordMapper;
    @Autowired
    private FileRecordResourcesMapper fileRecordResourcesMapper;
    @Autowired
    private FileRecordImagesMapper fileRecordImagesMapper;
    @Autowired
    private SequenceService sequenceService;
    @Override
    public CommonResult upload(FileRecordUploadParam param) {
        try {
            uploadFile(param.getFile(),param);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.success(true);
    }

    @Override
    public CommonResult mulitipartUpload(FileRecordUploadParam param) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (MultipartFile file : param.getFiles()) {
            Thread thread=new Thread(){
                @Override
                public void run() {
                    try {
                        uploadFile(file,param);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(thread);
        }
        return CommonResult.success(true);
    }

    private  void uploadFile(MultipartFile multipartFile,FileRecordUploadParam param) throws IOException {
        byte[] bytes = multipartFile.getBytes();
        long length = multipartFile.getSize();
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.indexOf("."),fileName.length()-1);
        FastDFSFile file = new FastDFSFile(bytes, ext);
        NameValuePair[] nameValuePairs = new NameValuePair[4];
        nameValuePairs[0] = new NameValuePair("fileName", fileName);
        nameValuePairs[1] = new NameValuePair("fileLength", String.valueOf(length));
        nameValuePairs[2] = new NameValuePair("fileExt", ext);
        nameValuePairs[3] = new NameValuePair("fileAuthor", FastDFSFile.FILE_DEFAULT_AUTHOR);
        FileUploadResult fileUploadResult = FileClientPool.upload(file, null);
        String fileType = param.getFileType();
        FileRecord record = new FileRecord();
        BeanCopyUtils.copyProperties(param,record);
        BeanCopyUtils.copyProperties(fileUploadResult,record);
        Long recordId = sequenceService.nextValue(null);
        record.setRecordId(recordId);
        record.setCreateTime(new Date());
        record.setContentType(multipartFile.getContentType());
        record.setFileSize(length);
        record.setOrigFileName(fileName);
        fileRecordMapper.insertSelective(record);

        if (StringUtils.equals(fileType, FileConstants.FileType.IMAGES.getCode())){
            FileRecordImages fileRecordImages = new FileRecordImages();
            fileRecordImages.setRecordId(recordId);
            fileRecordImages.setFromSystemId(param.getFromSystemId());
            fileRecordImages.setRecordImageId(sequenceService.nextValue(null));
            fileRecordImagesMapper.insertSelective(fileRecordImages);
        }
        if (StringUtils.equals(fileType, FileConstants.FileType.DOCUMENT.getCode())){
            FileRecordResources fileRecordResources = new FileRecordResources();
            fileRecordResources.setRecordId(recordId);
            fileRecordResources.setFromSystemId(param.getFromSystemId());
            fileRecordResources.setRecordResourcesId(sequenceService.nextValue(null));
            fileRecordResourcesMapper.insertSelective(fileRecordResources);
        }
        if (StringUtils.equals(fileType, FileConstants.FileType.MEDIA.getCode())){
            //调用课程视频的微服务
        }
    }
    @Override
    public CommonResult applyUploadToken(FileRecordApplyTokenParam param) {
        return null;
    }

    @Override
    public CommonResult download(FileRecordDowmloadParam param) {
        return null;
    }

    @Override
    public CommonResult remove(FileRecordRemoveParam param) {
        return null;
    }
}

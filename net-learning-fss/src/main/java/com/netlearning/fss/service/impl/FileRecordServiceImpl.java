package com.netlearning.fss.service.impl;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.param.TeachPlanMediaAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentAddParam;
import com.netlearning.framework.domain.fss.*;
import com.netlearning.framework.domain.fss.param.*;
import com.netlearning.framework.domain.fss.result.FileRecordResult;
import com.netlearning.framework.domain.fss.result.FileRecordUploadResult;
import com.netlearning.framework.em.FileConstants;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.fss.client.TeachPlanMediaControllerClientApi;
import com.netlearning.fss.client.TeachPlanMediaTencenControllerClientApi;
import com.netlearning.fss.client.TencentVodUploadClient;
import com.netlearning.fss.fastdfs.FastDFSFile;
import com.netlearning.fss.fastdfs.FileClientPool;
import com.netlearning.fss.fastdfs.FileUploadResult;
import com.netlearning.fss.mapper.FileRecordImagesMapper;
import com.netlearning.fss.mapper.FileRecordMapper;
import com.netlearning.fss.mapper.FileRecordResourcesMapper;
import com.netlearning.fss.service.FileRecordService;
import com.qcloud.vod.model.VodUploadResponse;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
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
    @Autowired
    private TeachPlanMediaControllerClientApi teachPlanMediaControllerClientApi;
    @Autowired
    private TencentVodUploadClient tencentVodUploadClient;
    @Autowired
    private TeachPlanMediaTencenControllerClientApi teachPlanMediaTencenControllerClientApi;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public CommonResult<List<FileRecordResult>> query(FileRecordQueryParam param) {

        FileRecordExample example = new FileRecordExample();
        FileRecordExample.Criteria criteria  = example.createCriteria();
        if (param.getFromSystemId() != null){
            criteria.andFromSystemIdEqualTo(param.getFromSystemId());
        }
        if (!CollectionUtils.isEmpty(param.getRecordIds())){
            criteria.andRecordIdIn(param.getRecordIds());
        }
        if (param.getRecordId() != null){
            criteria.andFromSystemIdEqualTo(param.getFromSystemId());
        }
        if (!CollectionUtils.isEmpty(param.getFromSystemIds())){
            criteria.andFromSystemIdIn(param.getFromSystemIds());
        }
        List<FileRecord> records =  fileRecordMapper.selectByExample(example);
        List<FileRecordResult> recordResults = BeanCopyUtils.copy(records,FileRecordResult.class);

        return CommonResult.success(recordResults);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public CommonResult upload(FileRecordUploadParam param) {
        try {
            FileRecordUploadResult fileRecordUploadResult = uploadFile(param.getFile(),param);
            return CommonResult.success(fileRecordUploadResult);
        } catch (IOException e) {
            return CommonResult.fail(ExceptionCode.FssCode.CODE007.code,ExceptionCode.FssCode.CODE007.message);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
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

    private  FileRecordUploadResult uploadFile(MultipartFile multipartFile,FileRecordUploadParam param) throws IOException {
        byte[] bytes = multipartFile.getBytes();
        long length = multipartFile.getSize();
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."),fileName.length());
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
        FileRecordUploadResult fileRecordUploadResult = new FileRecordUploadResult();
        fileRecordUploadResult.setFileAbsolutePath(fileUploadResult.getFileAbsolutePath());
        fileRecordUploadResult.setRecordId(recordId);
        fileRecordUploadResult.setFromSystemId(param.getFromSystemId());
        if (StringUtils.equals(fileType, FileConstants.FileType.IMAGES.getCode()) || StringUtils.isEmpty(fileType)){
            //用户课程图片
            FileRecordImages fileRecordImages = new FileRecordImages();
            fileRecordImages.setRecordId(recordId);
            fileRecordImages.setFromSystemId(param.getFromSystemId());
            Long recordImageId = sequenceService.nextValue(null);
            fileRecordUploadResult.setRecordImageId(recordImageId);
            fileRecordImages.setRecordImageId(recordImageId);
            fileRecordImages.setUserId(param.getUserId());
            fileRecordImages.setIsDefaultIcon(FileConstants.IsAvatar.NON_AVATAR.getCode());
            fileRecordImagesMapper.insertSelective(fileRecordImages);
        }
        if (StringUtils.equals(fileType, FileConstants.FileType.DOCUMENT.getCode())){
            //用户文档
            FileRecordResources fileRecordResources = new FileRecordResources();
            fileRecordResources.setRecordId(recordId);
            fileRecordResources.setFromSystemId(param.getFromSystemId());
            Long recordResourcesId = sequenceService.nextValue(null);
            fileRecordUploadResult.setRecordResourcesId(recordResourcesId);
            fileRecordResources.setRecordResourcesId(recordResourcesId);
            fileRecordResourcesMapper.insertSelective(fileRecordResources);
        }
        if (StringUtils.equals(fileType, FileConstants.FileType.MEDIA.getCode())){
            //调用课程视频的微服务
        }
        if (StringUtils.equals(fileType, FileConstants.FileType.AVATAR.getCode())){
            //用户头像
            //查询用户头像的图片是否存在
            FileRecordImagesExample example = new FileRecordImagesExample();
            FileRecordImagesExample.Criteria criteria = example.createCriteria();
            if (param.getFromSystemId() != null){
                criteria.andFromSystemIdEqualTo(param.getFromSystemId());
            }
            if (param.getUserId() != null){
                criteria.andUserIdEqualTo(param.getUserId());
            }
            criteria.andIsDefaultIconEqualTo(FileConstants.IsAvatar.AVATAR.getCode());
            List<FileRecordImages> fileRecordImagesList = fileRecordImagesMapper.selectByExample(example);
            //存在则修改，不存在则添加
            if (!CollectionUtils.isEmpty(fileRecordImagesList)){
//                fileRecordImagesMapper.deleteByPrimaryKey(fileRecordImagesList.get(0).getRecordImageId());
                FileRecordImages fileRecordImages = new FileRecordImages();
                fileRecordImages.setRecordImageId(fileRecordImagesList.get(0).getRecordImageId());
                fileRecordImages.setIsDefaultIcon(FileConstants.IsAvatar.NON_AVATAR.getCode());
                fileRecordImagesMapper.updateByPrimaryKeySelective(fileRecordImages);
            }
            FileRecordImages fileRecordImages = new FileRecordImages();
            fileRecordImages.setRecordId(recordId);
            fileRecordImages.setFromSystemId(param.getFromSystemId());
            Long recordImageId = sequenceService.nextValue(null);
            fileRecordUploadResult.setRecordImageId(recordImageId);
            fileRecordImages.setRecordImageId(recordImageId);
            fileRecordImages.setUserId(param.getUserId());
            fileRecordImages.setIsDefaultIcon(FileConstants.IsAvatar.AVATAR.getCode());
            fileRecordImagesMapper.insertSelective(fileRecordImages);

        }

        return fileRecordUploadResult;
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
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public CommonResult remove(FileRecordRemoveParam param) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public CommonResult uploadMedia(FileRecordUploadMediaParam param) {
        FileUploadResult fileUploadResult = null;
        byte[] bytes = null;
        long length = param.getMediaFile().getSize();
        String fileName = param.getMediaFile().getOriginalFilename();
        try {
            bytes = param.getMediaFile().getBytes();
            String ext = fileName.substring(fileName.lastIndexOf("."),fileName.length());
            FastDFSFile file = new FastDFSFile(bytes, ext);
            NameValuePair[] nameValuePairs = new NameValuePair[4];
            nameValuePairs[0] = new NameValuePair("fileName", fileName);
            nameValuePairs[1] = new NameValuePair("fileLength", String.valueOf(length));
            nameValuePairs[2] = new NameValuePair("fileExt", ext);
            nameValuePairs[3] = new NameValuePair("fileAuthor", FastDFSFile.FILE_DEFAULT_AUTHOR);
            fileUploadResult = FileClientPool.upload(file, null);
        } catch (IOException e) {
            return CommonResult.fail(ExceptionCode.FssCode.CODE007.code,ExceptionCode.FssCode.CODE007.message);
        }
            FileRecord record = new FileRecord();
            BeanCopyUtils.copyProperties(param,record);
            BeanCopyUtils.copyProperties(fileUploadResult,record);
            Long mediaRecordId = sequenceService.nextValue(null);
            record.setRecordId(mediaRecordId);
            record.setCreateTime(new Date());
            record.setContentType(param.getMediaFile().getContentType());
            record.setFileSize(length);
            record.setOrigFileName(fileName);
            fileRecordMapper.insertSelective(record);

            //图片封面已经上传直接传recordId
            if(param.getImagesRecordId() != null && param.getImageFile() == null){
                FileRecordImages fileRecordImages = new FileRecordImages();
                fileRecordImages.setRecordId(mediaRecordId);
                fileRecordImages.setFromSystemId(param.getFromSystemId());
                Long recordImageId = sequenceService.nextValue(null);
                fileRecordImages.setRecordImageId(recordImageId);
                fileRecordImages.setUserId(param.getUserId());
                fileRecordImagesMapper.insertSelective(fileRecordImages);
            }

            TeachPlanMediaAddParam teachPlanMediaAddParam = new TeachPlanMediaAddParam();
            teachPlanMediaAddParam.setCourseId(param.getCourseId());
            teachPlanMediaAddParam.setMediaFileoriginalName(param.getMediaFile().getOriginalFilename());
            teachPlanMediaAddParam.setMediaId(mediaRecordId);
            teachPlanMediaAddParam.setTeachplanId(param.getTeachplanId());
            teachPlanMediaAddParam.setMediaUrl(fileUploadResult.getFileAbsolutePath());
            teachPlanMediaAddParam.setRecordId(param.getImagesRecordId());//图片的recordId
            Long teachplanMediaId = this.sequenceService.nextValue(null);
            teachPlanMediaAddParam.setTeachplanMediaId(teachplanMediaId);
            CommonResult<Boolean> teachplanMediaAddResult = teachPlanMediaControllerClientApi.add(teachPlanMediaAddParam);
            if (!teachplanMediaAddResult.isSuccess()){
                return CommonResult.fail(ExceptionCode.FssCode.CODE007.code,ExceptionCode.FssCode.CODE007.message);
            }
            if (StringUtils.equals(FileConstants.IsUseType.USE.getCode(),param.getIsUse()) || StringUtils.isEmpty(param.getIsUse())){
                VodUploadResponse vodUploadResponse = tencentVodUploadClient.vodUploadClient(fileUploadResult.getFileAbsolutePath());

                TeachPlanMediaTencentAddParam teachPlanMediaTencentAddParam = new TeachPlanMediaTencentAddParam();
                teachPlanMediaTencentAddParam.setTencentMediaUrl(vodUploadResponse.getMediaUrl());
                teachPlanMediaTencentAddParam.setTeachplanMediaId(teachplanMediaId);
                teachPlanMediaTencentAddParam.setTencentFileid(Long.valueOf(vodUploadResponse.getFileId()));
                teachPlanMediaTencentAddParam.setTencentCoverUrl("");
                CommonResult<Boolean> teachPlanMediaTencentAddResult = teachPlanMediaTencenControllerClientApi.add(teachPlanMediaTencentAddParam);
                if (!teachPlanMediaTencentAddResult.isSuccess()){
                    return CommonResult.fail(ExceptionCode.FssCode.CODE007.code,ExceptionCode.FssCode.CODE007.message);
                }
            }

            return CommonResult.success(true);


    }
}

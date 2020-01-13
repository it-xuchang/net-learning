package com.netlearning.fss.controller;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.param.*;
import com.netlearning.framework.domain.fss.result.FileRecordResult;
import com.netlearning.fss.service.FileRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/28 23:13
 */
@RestController
@RequestMapping("/file/record")
public class FileRecordController {
    @Autowired
    private FileRecordService fileRecordService;

    @GetMapping("/query")
    public CommonResult<List<FileRecordResult>> query(@RequestParam(value = "recordId",required = false) Long recordId,
                              @RequestParam(value = "recordIds",required = false) List<Long> recordIds,
                              @RequestParam(value = "fromSystemId" ,required = false) Long fromSystemId,
                              @RequestParam(value = "fromSystemIds" ,required = false) List<Long> fromSystemIds ){
        FileRecordQueryParam param = new FileRecordQueryParam();
        param.setRecordId(recordId);
        param.setFromSystemId(fromSystemId);
        param.setRecordIds(recordIds);
        param.setFromSystemIds(fromSystemIds);
        return fileRecordService.query(param);
    }

    @PostMapping("/upload")
    public CommonResult upload(MultipartFile file,
                               @RequestParam(value = "userId" ,required = false) Long userId ,
                               @RequestParam(value = "tokenKey",required = false) String tokenKey,
                               @RequestParam(value = "fromSystemId" ,required = false) Long fromSystemId ,
                               @RequestParam(value = "fileType",required = false) String fileType){
        FileRecordUploadParam param = new FileRecordUploadParam();
        param.setTokenKey(tokenKey);
        param.setUserId(userId);
        param.setFile(file);
        param.setFileType(fileType);
        param.setFromSystemId(fromSystemId);
        return fileRecordService.upload(param);
    }

    /**
     * 两种情况，
     * 图片封面已上传的换，直接传图片资源的recordId  情况0
     * 图片封面未上传的换，直接传图片资源的文件资源 情况1
     * @param mediaFile 情况0和情况1 需要传
     * @param imageFile 情况0不传 情况1 需要传
     * @param teachplanId 情况0和情况1 需要传
     * @param courseId 情况0和情况1 需要传
     * @param imagesRecordId 情况1不传
     * @param userId 情况0和情况1 需要传
     * @param tokenKey 情况0和情况1 需要传
     * @param fromSystemId 情况0和情况1 需要传
     * @param fileImagesUrl 暂不考虑
     * @param isUse 是否上传到腾讯的点播 0是 1否 默认为0
     * @return
     */
    @PostMapping("/upload/media")
    public CommonResult uploadMedia(MultipartFile mediaFile,
                                    MultipartFile imageFile,
                               @RequestParam(value = "teachplanId" ,required = false) Long teachplanId,
                               @RequestParam(value = "courseId" ,required = false) Long courseId,
                               @RequestParam(value = "imagesRecordId" ,required = false) Long imagesRecordId,
                               @RequestParam(value = "userId" ,required = false) Long userId,
                               @RequestParam(value = "tokenKey",required = false) String tokenKey,
                               @RequestParam(value = "fromSystemId" ,required = false) Long fromSystemId,
                               @RequestParam(value = "fileImagesUrl",required = false) String fileImagesUrl,
                               @RequestParam(value = "isUse",required = false) String isUse){
        FileRecordUploadMediaParam param = new FileRecordUploadMediaParam();
        param.setTokenKey(tokenKey);
        param.setTeachplanId(teachplanId);
        param.setMediaFile(mediaFile);
        param.setImageFile(imageFile);
        param.setFromSystemId(fromSystemId);
        param.setFileImagesUrl(fileImagesUrl);
        param.setCourseId(courseId);
        param.setImagesRecordId(imagesRecordId);
        param.setUserId(userId);
        param.setIsUse(isUse);
        return fileRecordService.uploadMedia(param);
    }

    @PostMapping("/mulitipart/upload")
    public CommonResult mulitipartUpload(MultipartFile[] files,
                               @RequestParam(value = "userId" ,required = false) Long userId ,
                               @RequestParam(value = "tokenKey",required = false) String tokenKey,
                               @RequestParam(value = "fromSystemId" ,required = false) Long fromSystemId ,
                               @RequestParam(value = "fileType",required = false) String fileType){
        FileRecordUploadParam param = new FileRecordUploadParam();
        param.setTokenKey(tokenKey);
        param.setUserId(userId);
        param.setFiles(files);
        param.setFileType(fileType);
        param.setFromSystemId(fromSystemId);
        return fileRecordService.mulitipartUpload(param);
    }

    @GetMapping("/get/token")
    public CommonResult applyUploadToken(@RequestParam(value = "userId" ,required = false) String userId ,
                                         @RequestParam(value = "type",required = false) String type){
        FileRecordApplyTokenParam param = new FileRecordApplyTokenParam();

        return fileRecordService.applyUploadToken(param);
    }

    @PostMapping("/download")
    public CommonResult download(@RequestBody FileRecordDowmloadParam param){

        return fileRecordService.download(param);
    }

    @PostMapping("/remove")
    public CommonResult remove(@RequestBody FileRecordRemoveParam param){

        return fileRecordService.remove(param);
    }
}

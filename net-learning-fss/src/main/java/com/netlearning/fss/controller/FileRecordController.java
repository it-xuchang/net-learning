package com.netlearning.fss.controller;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.param.FileRecordApplyTokenParam;
import com.netlearning.framework.domain.fss.param.FileRecordDowmloadParam;
import com.netlearning.framework.domain.fss.param.FileRecordRemoveParam;
import com.netlearning.framework.domain.fss.param.FileRecordUploadParam;
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
    public CommonResult download(@RequestParam(value = "userId" ,required = false) String userId ,
                                 @RequestParam(value = "recordId" ,required = false) String recordId ,
                                 @RequestParam(value = "filType",required = false) String filType){
        FileRecordDowmloadParam param = new FileRecordDowmloadParam();
        return fileRecordService.download(param);
    }

    @PostMapping("/remove")
    public CommonResult remove(){
        FileRecordRemoveParam param = new FileRecordRemoveParam();
        return fileRecordService.remove(param);
    }
}

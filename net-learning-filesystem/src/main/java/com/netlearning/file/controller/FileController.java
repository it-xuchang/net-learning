package com.netlearning.file.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netlearning.api.file.FileControllerApi;
import com.netlearning.file.service.FileService;
import com.netlearning.framework.domain.filesystem.response.UploadFileResult;

@RestController
@RequestMapping("/filesystem")
public class FileController implements FileControllerApi {
    @Autowired
    FileService fileService;


    @Override
    @PostMapping("/upload")
    public UploadFileResult upload(MultipartFile multipartFile, String filetag, String businesskey, String metadata) {

        return fileService.upload(multipartFile, filetag, businesskey, metadata);
    }
}
package com.netlearning.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netlearning.api.file.FileSystemControllerApi;
import com.netlearning.framework.domain.filesystem.response.UploadFileResult;
import com.netlearning.service.FileSystemService;

@RestController
@RequestMapping("/filesystem")
public class FileSystemController implements FileSystemControllerApi {
    @Autowired
    FileSystemService fileSystemService;


    @Override
    @PostMapping("/upload")
    public UploadFileResult upload(MultipartFile multipartFile, String filetag, String businesskey, String metadata) {

        return fileSystemService.upload(multipartFile, filetag, businesskey, metadata);
    }
}
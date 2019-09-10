package com.netlearning.file.service;

import org.springframework.web.multipart.MultipartFile;

import com.netlearning.framework.domain.filesystem.response.UploadFileResult;

public interface FileService {

	public UploadFileResult upload(MultipartFile multipartFile, String filetag, String businesskey, String metadata);
}

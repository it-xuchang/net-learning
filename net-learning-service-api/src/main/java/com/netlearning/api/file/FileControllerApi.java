package com.netlearning.api.file;

import org.springframework.web.multipart.MultipartFile;

import com.netlearning.framework.domain.filesystem.response.UploadFileResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "文件接口", description = "文件的接口，文件的上传，下载，删除")
public interface FileControllerApi {

	// 文件上传
	@ApiOperation("上传文件接口")
	public UploadFileResult upload(MultipartFile multipartFile, String filetag, String businesskey, String metadata);

}

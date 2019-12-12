package com.netlearning.manage.media.service;

import com.netlearning.framework.domain.media.response.CheckChunkResult;
import com.netlearning.framework.model.response.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/12 10:34
 */
public interface MediaUploadService {
    ResponseResult register(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt);

    CheckChunkResult checkchunk(String fileMd5, Integer chunk, Integer chunkSize);

    ResponseResult uploadchunk(MultipartFile file, String fileMd5, Integer chunk);

    ResponseResult mergechunks(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt);
}

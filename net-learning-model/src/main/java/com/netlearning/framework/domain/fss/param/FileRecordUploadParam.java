package com.netlearning.framework.domain.fss.param;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class FileRecordUploadParam {
    private Long userId;
    private String tokenKey;
    private MultipartFile[] files;
    private MultipartFile file;
    private Long fromSystemId;
    private String fileType;
}

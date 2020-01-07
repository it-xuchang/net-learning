package com.netlearning.framework.domain.fss.param;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileRecordApplyTokenParam {
    private Long userId;
    private String tokenKey;
    private MultipartFile[] files;
}

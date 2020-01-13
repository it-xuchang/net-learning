package com.netlearning.framework.domain.fss.param;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileRecordRemoveParam {
    private Long userId;
    private Long recordId;
    private Long fromSystemId;
    private String filType;
}

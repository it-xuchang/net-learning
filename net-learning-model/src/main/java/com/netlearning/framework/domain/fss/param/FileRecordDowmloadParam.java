package com.netlearning.framework.domain.fss.param;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileRecordDowmloadParam {
    private Long userId;
    private Long recordId;
    private Long fromSystemId;
    private String filType;
    private String filePath;
}

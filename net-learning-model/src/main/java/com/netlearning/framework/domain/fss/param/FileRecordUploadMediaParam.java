package com.netlearning.framework.domain.fss.param;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileRecordUploadMediaParam {
    private Long teachplanId;
    private Long courseId;
    private Long userId;
    private Long imagesRecordId;
    private String tokenKey;
    private MultipartFile mediaFile;
    private MultipartFile imageFile;
    private Long fromSystemId;
    private String fileType;
    private String fileImagesUrl;
    private String isUse;
}

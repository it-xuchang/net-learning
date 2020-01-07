package com.netlearning.framework.domain.fss.param;

import lombok.Data;

@Data
public class FileRecordImagesEditParam {
    private Long recordImageId;

    private Long recordId;

    private Long fromSystemId;

    private Long userId;

    private String isDefault;

    private String isDefaultIcon;

}

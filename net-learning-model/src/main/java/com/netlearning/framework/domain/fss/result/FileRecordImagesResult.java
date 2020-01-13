package com.netlearning.framework.domain.fss.result;

import lombok.Data;

@Data
public class FileRecordImagesResult {
    private Long recordImageId;

    private FileRecordResult record;

    private Long fromSystemId;

    private Long userId;

    private String isDefault;

    private String isDefaultIcon;

}
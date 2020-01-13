package com.netlearning.framework.domain.fss.param;

import lombok.Data;

import java.util.List;

@Data
public class FileRecordImagesQueryParam {
    private Long recordImageId;

    private Long recordId;

    private Long fromSystemId;

    private Long userId;

    private String isDefault;

    private String isDefaultIcon;

    private List<Long> userIds;

    private List<Long> fromSystemIds;

}

package com.netlearning.framework.domain.fss.param;

import lombok.Data;

import java.util.List;

@Data
public class FileRecordResourcesQueryParam {
    private Long recordResourcesId;

    private Long recordId;

    private Long fromSystemId;

    private List<Long> fromSystemIds;

}

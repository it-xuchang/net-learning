package com.netlearning.framework.domain.fss.param;

import lombok.Data;

@Data
public class FileRecordResourcesAddParam {
    private Long recordResourcesId;

    private Long recordId;

    private Long fromSystemId;

}

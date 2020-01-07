package com.netlearning.framework.domain.fss.param;

import lombok.Data;

@Data
public class FileRecordResourcesEditParam {
    private Long recordResourcesId;

    private Long recordId;

    private Long fromSystemId;

}

package com.netlearning.framework.domain.fss.result;

import lombok.Data;

@Data
public class FileRecordResourcesResult {
    private Long recordResourcesId;

    private FileRecordResult record;

    private Long fromSystemId;

}

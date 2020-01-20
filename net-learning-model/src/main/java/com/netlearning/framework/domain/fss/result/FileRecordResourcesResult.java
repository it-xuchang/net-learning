package com.netlearning.framework.domain.fss.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class FileRecordResourcesResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordResourcesId;

    private FileRecordResult record;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long fromSystemId;

}

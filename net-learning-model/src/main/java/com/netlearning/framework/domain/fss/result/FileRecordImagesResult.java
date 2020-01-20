package com.netlearning.framework.domain.fss.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class FileRecordImagesResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordImageId;

    private FileRecordResult record;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long fromSystemId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String isDefault;

    private String isDefaultIcon;

}

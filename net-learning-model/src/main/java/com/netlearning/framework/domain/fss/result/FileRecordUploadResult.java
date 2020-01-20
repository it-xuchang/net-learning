package com.netlearning.framework.domain.fss.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/8 17:58
 */
@Data
public class FileRecordUploadResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordImageId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long fromSystemId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordResourcesId;

    private String fileAbsolutePath;

}

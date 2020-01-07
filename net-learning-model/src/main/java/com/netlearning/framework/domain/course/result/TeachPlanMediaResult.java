package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class TeachPlanMediaResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long teachplanMediaId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long mediaId;

    private String mediaFileoriginalName;

    private String mediaUrl;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long teachplanId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordId;

}

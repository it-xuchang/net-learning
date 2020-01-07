package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class SystemNavResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long systemNavId;

    private String systemNavUrl;

    private String imgUrl;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;

    private String systemNavHandlers;

}

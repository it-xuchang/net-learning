package com.netlearning.framework.domain.course.param;

import lombok.Data;

@Data
public class SystemNavAddParam {

    private String systemNavUrl;

    private Long courseId;

    private Long fromSystemId;

    private String systemNavHandlers;

}

package com.netlearning.framework.domain.course.param;

import lombok.Data;

@Data
public class SystemNavEditParam {
    private Long systemNavId;

    private String systemNavUrl;

    private Long courseId;

    private Long fromSystemId;

    private String systemNavHandlers;

}

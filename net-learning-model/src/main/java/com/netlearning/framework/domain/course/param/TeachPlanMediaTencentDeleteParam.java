package com.netlearning.framework.domain.course.param;

import lombok.Data;

@Data
public class TeachPlanMediaTencentDeleteParam {
    private Long teachplanMediaTencentId;

    private Long teachplanMediaId;

    private String tencentMediaUrl;

    private Long tencentFileid;

    private String tencentCoverUrl;

}

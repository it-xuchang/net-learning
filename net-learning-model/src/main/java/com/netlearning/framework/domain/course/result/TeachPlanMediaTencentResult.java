package com.netlearning.framework.domain.course.result;

import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/10 11:51
 */
@Data
public class TeachPlanMediaTencentResult {
    private Long teachplanMediaTencentId;

    private Long teachplanMediaId;

    private String tencentMediaUrl;

    private Long tencentFileid;

    private String tencentCoverUrl;
}

package com.netlearning.framework.domain.course;

import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/6 14:07
 */
@Data
public class CourseRecommendation {
    private Long courseId;
    private Integer count;
}

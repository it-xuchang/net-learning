package com.netlearning.framework.domain.course.result;

import lombok.Data;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/2/11 22:10
 */
@Data
public class PersonCourseResult {
    private CourseBaseResult courseBaseResult;
    private TeachPlanResult teachPlan;
}

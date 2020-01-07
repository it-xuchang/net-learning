package com.netlearning.framework.domain.course.result;

import lombok.Data;

import java.util.List;

@Data
public class BaseCourseTeachPlanResult {
    private String courseId;
    private List<TeachPlanResult> teachPlans;
}

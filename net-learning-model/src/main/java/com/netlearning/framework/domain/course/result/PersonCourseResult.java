package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
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
    private TeachPlanResult learningTeachPlan;
    private List<TeachPlanResult> teachPlans;
    private int progressBar;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
    private String status;
}

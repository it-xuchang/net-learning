package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.netlearning.framework.domain.userAuth.Teacher;
import lombok.Data;

@Data
public class CourseBaseDetailResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    private String courseName;
    private String users;
    private String description;
    private String grade;
    private String studymodel;
    private String teachmode;
    private String category;
    private String subCategory;
    private Double courseCountTime;
    private Teacher teacher;
    private Double courseAssessmentGrade;
    private BaseCourseTeachPlanResult courseTeachPlan;

}

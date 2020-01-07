package com.netlearning.framework.domain.course.param;

import lombok.Data;

import java.util.Date;

@Data
public class CourseAssessmentAddParam {

    private String courseAssessmentTitle;

    private String courseAssessmentContent;

    private Double courseAssessmentGrade;

    private Long courseId;

    private Long userId;

}

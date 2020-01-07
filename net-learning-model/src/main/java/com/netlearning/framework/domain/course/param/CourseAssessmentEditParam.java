package com.netlearning.framework.domain.course.param;

import com.netlearning.framework.domain.userAuth.User;
import lombok.Data;

import java.util.Date;

@Data
public class CourseAssessmentEditParam {
    private Long courseAssessmentId;

    private String courseAssessmentTitle;

    private String courseAssessmentContent;

    private Double courseAssessmentGrade;

    private Long courseId;

    private Long userId;

}

package com.netlearning.framework.domain.course.param;

import lombok.Data;

import java.util.Date;

@Data
public class LearningCourseEditParam {
    private Long learningId;

    private Long courseId;

    private Long userId;

    private String valid;

    private String createTime;

    private String endTime;

    private String status;

}

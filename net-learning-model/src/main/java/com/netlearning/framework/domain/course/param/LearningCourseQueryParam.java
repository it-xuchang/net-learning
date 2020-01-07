package com.netlearning.framework.domain.course.param;

import lombok.Data;

@Data
public class LearningCourseQueryParam {
    private Long learningId;

    private Long courseId;

    private Long userId;

    private Long teacherId;

    private String valid;

    private String createTime;

    private String endTime;

    private String status;

}

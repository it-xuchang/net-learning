package com.netlearning.framework.domain.course.param;

import lombok.Data;

@Data
public class LearningTeachplanEditParam {
    private Long learningTeachplanId;

    private Long teachplanId;

    private Long userId;

    private Double learningTime;

    private String status;

    private Long courseId;

}

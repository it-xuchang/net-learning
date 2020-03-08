package com.netlearning.framework.domain.course.param;

import lombok.Data;

import java.util.Date;

@Data
public class LearningTeachplanAddParam {

    private Long teachplanId;

    private Long userId;

    private Double learningTime;

    private String status;

    private Long courseId;

}

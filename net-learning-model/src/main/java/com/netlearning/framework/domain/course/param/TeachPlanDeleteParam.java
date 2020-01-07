package com.netlearning.framework.domain.course.param;

import lombok.Data;

@Data
public class TeachPlanDeleteParam {
    private Long teachplanId;

    private String teachplanName;

    private Long parentId;

    private String grade;

    private String teachplanType;

    private String description;

    private Double timeLength;

    private String courseId;

    private String orderby;

    private String status;

    private String tryLearn;

}

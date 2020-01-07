package com.netlearning.framework.domain.course.param;

import lombok.Data;

@Data
public class CourseQuziQueryParam {

    private Long courseQuziId;

    private String courseQuziTitle;

    private String courseQuziContent;

    private String isOverHead;

    private Long courseId;

    private String courseQuziType;

    private String isShow;

}

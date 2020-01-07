package com.netlearning.framework.domain.course.param;

import lombok.Data;

import java.util.Date;

@Data
public class CourseQuziAddParam {

    private String courseQuziTitle;

    private String courseQuziContent;

    private String isOverHead;

    private Long courseId;

    private String courseQuziType;

    private String isShow;

}

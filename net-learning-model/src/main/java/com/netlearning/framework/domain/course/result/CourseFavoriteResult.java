package com.netlearning.framework.domain.course.result;

import lombok.Data;

import java.util.Date;

@Data
public class CourseFavoriteResult {
    private Long courseFavoriteId;

    private Long userId;

    private Date createTime;

    private Date endTime;

    private Long courseId;

    private CourseBaseResult courseBase;
}

package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class CourseFavoriteResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseFavoriteId;

    private Long userId;

    private Date createTime;

    private Date endTime;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;

    private CourseBaseResult courseBase;
}

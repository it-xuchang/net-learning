package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class LearningCourseResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long learningId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String valid;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date endTime;

    private String status;

    private CourseBaseResult courseBaseResult;

}

package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class CourseQuziResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseQuziId;

    private String courseQuziTitle;

    private String courseQuziContent;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    private String isOverHead;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;

    private String courseQuziType;

    private String isShow;

}

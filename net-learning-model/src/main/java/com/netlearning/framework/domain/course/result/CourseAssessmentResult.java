package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.netlearning.framework.domain.userAuth.User;
import com.netlearning.framework.domain.userAuth.result.UserResult;
import lombok.Data;

import java.util.Date;

@Data
public class CourseAssessmentResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseAssessmentId;

    private String courseAssessmentTitle;

    private String courseAssessmentContent;

    private Double courseAssessmentGrade;

    private User user;
    private UserResult userResult;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;

}

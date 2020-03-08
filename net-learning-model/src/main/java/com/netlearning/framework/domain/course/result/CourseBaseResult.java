package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class CourseBaseResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long teacherId;

    private String courseName;

    private String users;

    private String category;

    private String grade;

    private String studymodel;

    private String teachmode;

    private String subCategory;

    private String status;

    private String deptId;

    private String description;

    private String courseImageUrl;

}

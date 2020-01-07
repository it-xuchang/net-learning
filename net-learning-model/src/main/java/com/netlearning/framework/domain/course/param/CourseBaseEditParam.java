package com.netlearning.framework.domain.course.param;

import lombok.Data;

@Data
public class CourseBaseEditParam {
    private Long courseId;

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

}

package com.netlearning.framework.domain.userAuth;

import lombok.Data;

import java.util.Date;

@Data
public class TeacherParam {
    private Long teacherId;

    private String teacherName;

    private String password;

    private Long deptId;

    private String email;

    private String mobile;

    private String status;

    private String startCreateTime;

    private String endCreateTime;

    private String sex;

    private String description;

    private String avatar;

}

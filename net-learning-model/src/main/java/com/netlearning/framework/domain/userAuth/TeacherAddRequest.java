package com.netlearning.framework.domain.userAuth;

import lombok.Data;

@Data
public class TeacherAddRequest {
    private Long roleId;

    private String teacherName;

    private String password;

    private Long deptId;

    private String email;

    private String mobile;

    private String sex;

    private String description;

    private String avatar;

}

package com.netlearning.framework.domain.userAuth;

import lombok.Data;

@Data
public class UserAddRequest {

    private Long roleId;

    private String username;

    private String password;

    private Long deptId;

    private String email;

    private String mobile;

    private String sex;

    private String description;

    private String avatar;


}

package com.netlearning.framework.domain.userAuth;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserParam {
    private Long userId;

    private String username;

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

    private List<Long> userIds;

}

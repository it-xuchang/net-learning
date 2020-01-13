package com.netlearning.framework.domain.auth.param;

import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/11 14:22
 */
@Data
public class UserAccessRegisterParam {
    private String userType;
    private String mobile;
    private String email;
    private String username;
    private String password;

}

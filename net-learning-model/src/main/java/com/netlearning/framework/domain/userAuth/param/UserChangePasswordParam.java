package com.netlearning.framework.domain.userAuth.param;

import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:44
 */
@Data
public class UserChangePasswordParam {
    private String email;
    private String mobile;
    private String oldPassword;
    private String newPassword;

}

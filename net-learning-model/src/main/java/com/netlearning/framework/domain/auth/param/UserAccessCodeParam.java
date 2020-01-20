package com.netlearning.framework.domain.auth.param;

import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/11 14:22
 */
@Data
public class UserAccessCodeParam {
    private String userAccount;
    private String userType;
}

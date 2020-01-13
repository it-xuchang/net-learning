package com.netlearning.auth.service;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.auth.param.UserAccessChangePasswordParam;
import com.netlearning.framework.domain.auth.param.UserAccessLoginParam;
import com.netlearning.framework.domain.auth.param.UserAccessRegisterParam;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/11 14:18
 */
public interface UserAccessService {
    CommonResult login(UserAccessLoginParam param);

    CommonResult registry(UserAccessRegisterParam param);

    CommonResult changePassword(UserAccessChangePasswordParam param);
}

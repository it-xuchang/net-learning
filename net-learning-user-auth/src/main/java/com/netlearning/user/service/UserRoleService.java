package com.netlearning.user.service;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.UserRole;
import com.netlearning.framework.domain.userAuth.UserRoleResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:31
 */
public interface UserRoleService {
    CommonResult<List<UserRoleResult>> query(UserRole userRole);

    CommonResult<Boolean> add(UserRole userRole);

    CommonResult<Boolean> edit(UserRole userRole);

    CommonResult<Boolean> delete(UserRole userRole);
}

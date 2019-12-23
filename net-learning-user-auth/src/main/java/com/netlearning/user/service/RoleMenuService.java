package com.netlearning.user.service;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:23
 */
public interface RoleMenuService {
    CommonResult<RoleMenuResult> query(RoleMenuParam roleMenuParam);

    CommonResult<List<MenuItem>> tree(RoleTreeParam roleTreeParam);

    CommonResult<Boolean> add(RoleMenu roleMenu);

    CommonResult<Boolean> edit(RoleMenu roleMenu);

    CommonResult<Boolean> delete(RoleMenu roleMenu);
}

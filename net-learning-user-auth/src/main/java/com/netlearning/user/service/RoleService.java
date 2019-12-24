package com.netlearning.user.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 16:49
 */
public interface RoleService {
    CommonResult<List<Role>> query(RoleParam roleParam);

    CommonResult<CommonPageResult<Role>> page(RoleParam roleParam, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(RoleAddRequest role);

    CommonResult<Boolean> edit(RoleEditRequest roleEditRequest);

    CommonResult<Boolean> delete(RoleDeleteRequest roleDeleteRequest);
}

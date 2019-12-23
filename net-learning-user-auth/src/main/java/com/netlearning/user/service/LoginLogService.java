package com.netlearning.user.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.LoginLog;
import com.netlearning.framework.domain.userAuth.LoginLogParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/21 9:55
 */
public interface LoginLogService {
    CommonResult<List<LoginLog>> query(LoginLogParam logParam);

    CommonResult<CommonPageResult<LoginLog>> page(LoginLogParam logParam, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(LoginLog log);

    CommonResult<Boolean> edit(LoginLog log);

    CommonResult<Boolean> delete(LoginLog log);
}

package com.netlearning.user.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.Log;
import com.netlearning.framework.domain.userAuth.LogParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/21 9:58
 */
public interface LogService {
    CommonResult<List<Log>> query(LogParam logParam);

    CommonResult<CommonPageResult<Log>> page(LogParam logParam, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(Log log);

    CommonResult<Boolean> edit(Log log);

    CommonResult<Boolean> delete(Long id);
}

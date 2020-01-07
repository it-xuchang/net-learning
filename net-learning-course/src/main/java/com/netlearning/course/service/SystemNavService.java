package com.netlearning.course.service;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.SystemNavAddParam;
import com.netlearning.framework.domain.course.param.SystemNavEditParam;
import com.netlearning.framework.domain.course.result.SystemNavResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/6 10:57
 */
public interface SystemNavService {
    CommonResult<Boolean> add(SystemNavAddParam requset);

    CommonResult<Boolean> edit(SystemNavEditParam requset);

    CommonResult<Boolean> delete(Long systemNavId);

    CommonResult<List<SystemNavResult>> query();
}

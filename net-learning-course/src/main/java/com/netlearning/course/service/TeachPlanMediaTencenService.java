package com.netlearning.course.service;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentDeleteParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentEditParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentQueryParam;
import com.netlearning.framework.domain.course.result.TeachPlanMediaTencentResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/10 14:07
 */
public interface TeachPlanMediaTencenService {
    CommonResult<Boolean> add(TeachPlanMediaTencentAddParam param);

    CommonResult<Boolean> edit(TeachPlanMediaTencentEditParam param);

    CommonResult<List<TeachPlanMediaTencentResult>> query(TeachPlanMediaTencentQueryParam param);

    CommonResult<Boolean> delete(TeachPlanMediaTencentDeleteParam param);
}

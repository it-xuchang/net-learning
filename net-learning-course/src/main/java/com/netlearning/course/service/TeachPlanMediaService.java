package com.netlearning.course.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.TeachPlanMediaAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaDeleteParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaEditParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaQueryParam;
import com.netlearning.framework.domain.course.result.TeachPlanMediaResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 22:29
 */
public interface TeachPlanMediaService {
    CommonResult<Boolean> add(TeachPlanMediaAddParam request);

    CommonResult<Boolean> edit(TeachPlanMediaEditParam request);

    CommonResult<Boolean> delete(List<Long> teachplanMediaIds);

    CommonResult<CommonPageResult<TeachPlanMediaResult>> page(TeachPlanMediaQueryParam param, CommonPageInfo commonPageInfo);

    CommonResult<List<TeachPlanMediaResult>> query(TeachPlanMediaQueryParam param);
}

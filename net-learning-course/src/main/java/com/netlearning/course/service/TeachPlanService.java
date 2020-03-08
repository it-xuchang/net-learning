package com.netlearning.course.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.TeachPlanAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanDeleteParam;
import com.netlearning.framework.domain.course.param.TeachPlanEditParam;
import com.netlearning.framework.domain.course.param.TeachPlanQueryParam;
import com.netlearning.framework.domain.course.result.BaseCourseTeachPlanResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 22:28
 */
public interface TeachPlanService {
    CommonResult add(TeachPlanAddParam request);

    CommonResult<Boolean> edit(TeachPlanEditParam request);

    CommonResult<Boolean> delete(TeachPlanDeleteParam param);

    CommonResult<List<BaseCourseTeachPlanResult>> query(TeachPlanQueryParam param);

    CommonResult<CommonPageResult<BaseCourseTeachPlanResult>> page(TeachPlanQueryParam param, CommonPageInfo commonPageInfo);
}

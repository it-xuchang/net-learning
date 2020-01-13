package com.netlearning.course.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.LearningCourseAddParam;
import com.netlearning.framework.domain.course.param.LearningCourseEditParam;
import com.netlearning.framework.domain.course.param.LearningCourseQueryParam;
import com.netlearning.framework.domain.course.result.UserLearningCourseResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 22:26
 */
public interface LearningCourseService {
    CommonResult<UserLearningCourseResult> query(LearningCourseQueryParam param);

    CommonResult<CommonPageResult<UserLearningCourseResult>> page(LearningCourseQueryParam param, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(LearningCourseAddParam request);

    CommonResult<Boolean> edit(LearningCourseEditParam request);

    CommonResult<Boolean> delete(List<Long> ids);
}

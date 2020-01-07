package com.netlearning.course.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.CourseAssessmentAddParam;
import com.netlearning.framework.domain.course.param.CourseAssessmentEditParam;
import com.netlearning.framework.domain.course.param.CourseAssessmentQueryParam;
import com.netlearning.framework.domain.course.result.CourseAssessmentResult;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/7 13:16
 */
public interface CourseAssessmentService {
    CommonResult<CommonPageResult<CourseAssessmentResult>> page(CourseAssessmentQueryParam param, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(CourseAssessmentAddParam param);

    CommonResult<Boolean> edit(CourseAssessmentEditParam param);

    CommonResult<Boolean> delete(Long courseAssessmentId);
}

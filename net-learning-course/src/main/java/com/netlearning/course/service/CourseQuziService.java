package com.netlearning.course.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.CourseQuziAddParam;
import com.netlearning.framework.domain.course.param.CourseQuziDeleteParam;
import com.netlearning.framework.domain.course.param.CourseQuziEditParam;
import com.netlearning.framework.domain.course.param.CourseQuziQueryParam;
import com.netlearning.framework.domain.course.result.CourseQuziResult;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/7 13:14
 */
public interface CourseQuziService {
    CommonResult<CommonPageResult<CourseQuziResult>> page(CommonPageInfo commonPageInfo, CourseQuziQueryParam param);

    CommonResult<Boolean> add(CourseQuziAddParam param);

    CommonResult<Boolean> edit(CourseQuziEditParam param);

    CommonResult<Boolean> delete(CourseQuziDeleteParam param);
}

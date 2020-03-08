package com.netlearning.course.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.CourseFavoriteAddParam;
import com.netlearning.framework.domain.course.param.CourseFavoriteDeleteParam;
import com.netlearning.framework.domain.course.param.CourseFavoriteQueryParam;
import com.netlearning.framework.domain.course.result.CourseFavoriteResult;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/2/12 16:30
 */
public interface CourseFavoriteService {
    CommonResult add(CourseFavoriteAddParam param);

    CommonResult delete(CourseFavoriteDeleteParam param);

    CommonResult<CommonPageResult<CourseFavoriteResult>> page(CourseFavoriteQueryParam param, CommonPageInfo commonPageInfo);
}

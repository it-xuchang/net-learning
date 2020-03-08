package com.netlearning.course.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.*;
import com.netlearning.framework.domain.course.result.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 20:55
 */
public interface CourseBaseService {
    CommonResult<List<CourseBaseResult>> query(CourseBaseQueryParam param);

    CommonResult<CommonPageResult<CourseBaseResult>> page(CourseBaseQueryParam param, CommonPageInfo commonPageInfo);

    CommonResult add(CourseBaseAddParam request);

    CommonResult<Boolean> edit(CourseBaseEditParam request);

    CommonResult<Boolean> delete(CourseBaseDeleteParam request);

    CommonResult<List<CourseRecommendationResult>> queryCourseRecommendation(Long size);

    CommonResult<List<RecommendedCourseDirectionResult>> queryRecommendedCourseDirection(Long size, Long categoryId, String grade);

    CommonResult<CourseBaseDetailResult> queryCouresDetail(CourseBaseQueryParam param);

    CommonResult<CourseAllDetailResult> queryCourseAllDetail(CourseAllDetailParam param);

    CommonResult<Boolean> changeStatus(CourseBaseEditParam request);
}

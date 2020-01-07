package com.netlearning.course.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.CategoryAddParam;
import com.netlearning.framework.domain.course.param.CategoryDeleteParam;
import com.netlearning.framework.domain.course.param.CategoryEditParam;
import com.netlearning.framework.domain.course.param.CategoryQueryParam;
import com.netlearning.framework.domain.course.result.CategoryResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 20:58
 */
public interface CategoryService {
    CommonResult<List<CategoryResult>> query(CategoryQueryParam param);

    CommonResult<CommonPageResult<CategoryResult>> page(CategoryQueryParam param, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(CategoryAddParam request);

    CommonResult<Boolean> edit(CategoryEditParam request);

    CommonResult<Boolean> delete(List<Long> categoryIds);
}

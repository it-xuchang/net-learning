package com.netlearning.course.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionAddParam;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionDeleteParam;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionEditParam;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionQueryParam;
import com.netlearning.framework.domain.course.result.FrequentlyAskedQuestionResult;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/7 16:52
 */
public interface FrequentlyAskedQuestionService {
    CommonResult<CommonPageResult<FrequentlyAskedQuestionResult>> page(FrequentlyAskedQuestionQueryParam param, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(FrequentlyAskedQuestionAddParam param);

    CommonResult<Boolean> edit(FrequentlyAskedQuestionEditParam param);

    CommonResult<Boolean> delete(FrequentlyAskedQuestionDeleteParam param);
}

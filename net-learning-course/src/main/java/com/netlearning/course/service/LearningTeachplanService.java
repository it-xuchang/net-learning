package com.netlearning.course.service;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.LearningTeachplanAddParam;
import com.netlearning.framework.domain.course.param.LearningTeachplanEditParam;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/2/12 16:17
 */
public interface LearningTeachplanService {
    CommonResult<Boolean> add(LearningTeachplanAddParam param);

    CommonResult<Boolean> edit(LearningTeachplanEditParam param);
}

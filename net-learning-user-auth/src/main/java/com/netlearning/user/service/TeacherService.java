package com.netlearning.user.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.Teacher;
import com.netlearning.framework.domain.userAuth.TeacherAddRequest;
import com.netlearning.framework.domain.userAuth.TeacherParam;
import com.netlearning.framework.domain.userAuth.result.TeacherRecommendationResult;
import com.netlearning.framework.domain.userAuth.result.TeacherResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:14
 */
public interface TeacherService {
    CommonResult<List<TeacherResult>> query(TeacherParam teacherParam);

    CommonResult<CommonPageResult<TeacherResult>> page(TeacherParam teacherParam, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(TeacherAddRequest teacher);

    CommonResult<Boolean> edit(Teacher teacher);

    CommonResult<Boolean> delete(Long teacherId);

    CommonResult<List<TeacherRecommendationResult>> queryTeacherRecommendation(Long size);
}

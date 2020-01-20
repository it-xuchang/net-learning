package com.netlearning.user.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.UserAddRequest;
import com.netlearning.framework.domain.userAuth.UserParam;
import com.netlearning.framework.domain.userAuth.param.MyCoursQueryParam;
import com.netlearning.framework.domain.userAuth.param.UserChangePasswordParam;
import com.netlearning.framework.domain.userAuth.param.UserDeleteParam;
import com.netlearning.framework.domain.userAuth.param.UserEditParam;
import com.netlearning.framework.domain.userAuth.result.MyCourseResult;
import com.netlearning.framework.domain.userAuth.result.UserResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 16:11
 */
public interface UserService {
    CommonResult<List<UserResult>> query(UserParam userParam);

    CommonResult<CommonPageResult<UserResult>> page(UserParam userParam, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(UserAddRequest user);

    CommonResult<Boolean> edit(UserEditParam user);

    CommonResult<Boolean> delete(UserDeleteParam param);

    CommonResult<MyCourseResult> queryMyCourse(MyCoursQueryParam param);

    CommonResult changePassword(UserChangePasswordParam param);
}

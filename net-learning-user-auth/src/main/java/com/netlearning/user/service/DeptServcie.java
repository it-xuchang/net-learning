package com.netlearning.user.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.Dept;
import com.netlearning.framework.domain.userAuth.DeptParam;
import com.netlearning.framework.domain.userAuth.param.DeptAddParam;
import com.netlearning.framework.domain.userAuth.param.DeptDeleteParam;
import com.netlearning.framework.domain.userAuth.param.DeptEditParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:41
 */
public interface DeptServcie {
    CommonResult<List<Dept>> query(DeptParam dept);

    CommonResult<CommonPageResult<Dept>> page(DeptParam dept, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(DeptAddParam dept);

    CommonResult<Boolean> edit(DeptEditParam dept);

    CommonResult<Boolean> delete(DeptDeleteParam dept);
}

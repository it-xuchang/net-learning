package com.netlearning.user.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.Dict;
import com.netlearning.framework.domain.userAuth.DictParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:33
 */
public interface DictService {
    CommonResult<List<Dict>> query(DictParam dictParam);

    CommonResult<CommonPageResult<Dict>> page(DictParam dictParam, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(Dict dict);

    CommonResult<Boolean> edit(Dict dict);

    CommonResult<Boolean> delete(Long dictId);
}

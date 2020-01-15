package com.netlearning.user.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.Menu;
import com.netlearning.framework.domain.userAuth.MenuItem;
import com.netlearning.framework.domain.userAuth.MenuParam;
import com.netlearning.framework.domain.userAuth.param.MenuAddParam;
import com.netlearning.framework.domain.userAuth.param.MenuDeleteParam;
import com.netlearning.framework.domain.userAuth.param.MenuEditParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:48
 */
public interface MenuService {
    CommonResult<List<Menu>> query(MenuParam menu);

    CommonResult<CommonPageResult<Menu>> page(MenuParam menu, CommonPageInfo commonPageInfo);

    CommonResult<Boolean> add(MenuAddParam menuAddParam);

    CommonResult<Boolean> edit(MenuEditParam menuEditParam);

    CommonResult<Boolean> delete(MenuDeleteParam menuDeleteParam);

    CommonResult<List<MenuItem>> tree(MenuParam menu);
}

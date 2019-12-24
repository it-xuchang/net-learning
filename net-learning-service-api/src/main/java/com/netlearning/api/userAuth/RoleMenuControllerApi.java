package com.netlearning.api.userAuth;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.MenuItem;
import com.netlearning.framework.domain.userAuth.RoleMenu;
import com.netlearning.framework.domain.userAuth.RoleMenuRequest;
import com.netlearning.framework.domain.userAuth.RoleMenuResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/23 10:52
 */
@Api(value = "角色菜单管理",description = "角色菜单管理")
public interface RoleMenuControllerApi {

    public CommonResult<RoleMenuResult> query(@RequestParam(value = "roleId",required = false) Long roleId,
                                              @RequestParam(value = "menuParentId",required = false) Long menuParentId);

    public CommonResult<List<MenuItem>> tree(@RequestParam(value = "roleId",required = false) Long roleId,
                                             @RequestParam(value = "menuParentId",required = false) Long menuParentId);

    public CommonResult<Boolean> add(@RequestBody RoleMenuRequest roleMenu);

    public CommonResult<Boolean> edit(@RequestBody RoleMenu roleMenu);

    public CommonResult<Boolean> delete(RoleMenu roleMenu);
}

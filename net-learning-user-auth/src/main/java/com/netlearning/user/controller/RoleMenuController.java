package com.netlearning.user.controller;

import com.netlearning.api.userAuth.RoleMenuControllerApi;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.*;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:23
 */
@RestController
@RequestMapping("/role/menu")
public class RoleMenuController implements RoleMenuControllerApi {
    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 查询该角色下的所有菜单--无树形结构
     * @param roleId
     * @param menuParentId 菜单id
     * @return
     */
    @Override
    @GetMapping("/query")
    public CommonResult<RoleMenuResult> query(@RequestParam(value = "roleId",required = false) Long roleId,
                                              @RequestParam(value = "menuParentId",required = false) Long menuParentId){
        if (roleId == null){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        RoleMenuParam roleMenuParam = new RoleMenuParam();
        roleMenuParam.setRoleId(roleId);
        roleMenuParam.setMenuId(menuParentId);
        return roleMenuService.query(roleMenuParam);
    }

    @Override
    @GetMapping("/tree")
    public CommonResult<List<MenuItem>> tree(@RequestParam(value = "roleId",required = false) Long roleId,
                                             @RequestParam(value = "menuParentId",required = false) Long menuParentId){
        RoleTreeParam roleTreeParam = new RoleTreeParam();
        roleTreeParam.setRoleId(roleId);
        roleTreeParam.setMenuParentId(menuParentId);
        return roleMenuService.tree(roleTreeParam);
    }

    @Override
    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody RoleMenuRequest roleMenu){
        if (roleMenu.getRoleId() == null){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (CollectionUtils.isEmpty(roleMenu.getMenuIds())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        return roleMenuService.add(roleMenu);
    }

    @Override
    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody RoleMenu roleMenu){
        return roleMenuService.edit(roleMenu);
    }

    @Override
    @PostMapping("/delete")
    public CommonResult<Boolean> delete(RoleMenu roleMenu){
        return roleMenuService.delete(roleMenu);
    }
}

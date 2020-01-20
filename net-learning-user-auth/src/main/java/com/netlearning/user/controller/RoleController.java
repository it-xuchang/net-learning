package com.netlearning.user.controller;

import com.netlearning.api.userAuth.RoleControllerApi;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.*;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:44
 */
@RestController
@RequestMapping("/role")
public class RoleController implements RoleControllerApi {
    @Autowired
    private RoleService roleService;

    @Override
    @GetMapping("/query")
    public CommonResult<List<Role>> query(@RequestParam(value = "roleId",required = false) Long roleId,
                                          @RequestParam(value = "roleName",required = false) String roleName,
                                          @RequestParam(value = "remark",required = false) String remark,
                                          @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                          @RequestParam(value = "endCreateTime",required = false) String endCreateTime){
        RoleParam roleParam = new RoleParam();
        roleParam.setRemark(remark);
        roleParam.setRoleName(roleName);
        roleParam.setEndCreateTime(endCreateTime);
        roleParam.setStartCreateTime(startCreateTime);
        roleParam.setRoleId(roleId);
        return roleService.query(roleParam);
    }
    @Override
    @GetMapping("/page")
    public CommonResult<CommonPageResult<Role>> page(@RequestParam(value = "roleId",required = false) Long roleId,
                                                     @RequestParam(value = "roleName",required = false) String roleName,
                                                     @RequestParam(value = "remark",required = false) String remark,
                                                     @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                                     @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                                     @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        RoleParam roleParam = new RoleParam();
        roleParam.setRemark(remark);
        roleParam.setRoleName(roleName);
        roleParam.setEndCreateTime(endCreateTime);
        roleParam.setStartCreateTime(startCreateTime);
        roleParam.setRoleId(roleId);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return roleService.page(roleParam,commonPageInfo);
    }

    /**
     * 添加角色--绑定菜单
     * @param role
     * @return
     */
    @Override
    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody RoleAddRequest role){
        if (StringUtils.isEmpty(role.getRemark())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (StringUtils.isEmpty(role.getRoleName())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (CollectionUtils.isEmpty(role.getMenuIds())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        return roleService.add(role);
    }

    @Override
    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody RoleEditRequest roleEditRequest){
        return roleService.edit(roleEditRequest);
    }

    @Override
    @PostMapping("/delete")
    public CommonResult<Boolean> delete(@RequestBody RoleDeleteRequest roleDeleteRequest){
        return roleService.delete(roleDeleteRequest);
    }
}

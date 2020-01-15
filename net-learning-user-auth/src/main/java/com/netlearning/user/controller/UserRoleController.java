package com.netlearning.user.controller;

import com.netlearning.api.userAuth.UserRoleControllerApi;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.domain.userAuth.UserRole;
import com.netlearning.framework.domain.userAuth.UserRoleResult;
import com.netlearning.user.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:29
 */
@RestController
@RequestMapping("/user/role")
public class UserRoleController implements UserRoleControllerApi {
    @Autowired
    private UserRoleService userRoleService;

    @Override
    @GetMapping("/query")
    public CommonResult<List<UserRoleResult>> query(@RequestParam(value = "userId",required = false) Long userId){
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        return userRoleService.query(userRole);
    }

    @Override
    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody UserRole userRole){
        if (userRole.getRoleId() == null){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (userRole.getUserId() == null){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        return userRoleService.add(userRole);
    }

    @Override
    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody UserRole userRole){
        if (userRole.getRoleId() == null){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (userRole.getUserId() == null){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        return userRoleService.edit(userRole);
    }

    @Override
    @PostMapping("/delete")
    public CommonResult<Boolean> delete(UserRole userRole){
        return userRoleService.delete(userRole);
    }

}

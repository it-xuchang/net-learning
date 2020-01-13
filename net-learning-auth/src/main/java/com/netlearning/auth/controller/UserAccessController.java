package com.netlearning.auth.controller;

import com.netlearning.auth.service.UserAccessService;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.auth.param.UserAccessChangePasswordParam;
import com.netlearning.framework.domain.auth.param.UserAccessLoginParam;
import com.netlearning.framework.domain.auth.param.UserAccessRegisterParam;
import com.netlearning.framework.domain.auth.result.UserAccessLoginResult;
import com.netlearning.framework.domain.auth.result.UserAccessRegisterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/11 14:12
 */
@RestController
@RequestMapping("/user/access")
public class UserAccessController {
    @Autowired
    private UserAccessService userAccessService;

    @PostMapping("/login")
    public CommonResult<UserAccessLoginResult> login(@RequestBody UserAccessLoginParam param){

        return userAccessService.login(param);
    }

    @PostMapping("/register")
    public CommonResult<UserAccessRegisterResult> registry(@RequestBody UserAccessRegisterParam param){

        return userAccessService.registry(param);
    }

    @PostMapping("/change/password")
    public CommonResult changePassword(@RequestBody UserAccessChangePasswordParam param){

        return userAccessService.changePassword(param);
    }
}

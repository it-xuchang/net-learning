package com.netlearning.auth.controller;

import com.netlearning.auth.service.UserAccessService;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.auth.param.UserAccessChangePasswordParam;
import com.netlearning.framework.domain.auth.param.UserAccessCodeParam;
import com.netlearning.framework.domain.auth.param.UserAccessLoginParam;
import com.netlearning.framework.domain.auth.param.UserAccessRegisterParam;
import com.netlearning.framework.domain.auth.result.UserAccessLoginResult;
import com.netlearning.framework.domain.auth.result.UserAccessRegisterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.ipc.netty.http.server.HttpServerRequest;

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

    /**
     * 登录
     * @param param
     * @return
     */
    @PostMapping("/login")
    public CommonResult<UserAccessLoginResult> login(@RequestBody UserAccessLoginParam param, HttpServerRequest request){
        return userAccessService.login(param);
    }

    /**
     * 注册
     * @param param
     * @return
     */
    @PostMapping("/register")
    public CommonResult<UserAccessRegisterResult> registry(@RequestBody UserAccessRegisterParam param){

        return userAccessService.registry(param);
    }

    /**
     * 忘记密码
     * @param param
     * @return
     */
    @PostMapping("/forget/password")
    public CommonResult forgetPassword(@RequestBody UserAccessChangePasswordParam param){

        return userAccessService.forgetPassword(param);
    }

    /**
     * 获取手机号或者邮箱的验证码
     * @return
     */
    @PostMapping("/get/code")
    public CommonResult getCode(@RequestBody UserAccessCodeParam param){

        return userAccessService.getCode(param);
    }
}

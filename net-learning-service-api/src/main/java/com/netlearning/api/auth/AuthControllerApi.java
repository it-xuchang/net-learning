package com.netlearning.api.auth;

import com.netlearning.framework.domain.ucenter.request.LoginRequest;
import com.netlearning.framework.domain.ucenter.response.JwtResult;
import com.netlearning.framework.domain.ucenter.response.LoginResult;
import com.netlearning.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 14:38
 */
@Api(value = "用户认证",description = "用户认证接口")
public interface AuthControllerApi {

    @ApiOperation("登录")
    public LoginResult login(LoginRequest loginRequest);

    @ApiOperation("退出")
    public ResponseResult logout();

    @ApiOperation("查询用户jwt令牌")
    public JwtResult userjwt();
}

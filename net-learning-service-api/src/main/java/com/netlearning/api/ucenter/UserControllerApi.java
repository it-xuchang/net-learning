package com.netlearning.api.ucenter;

import com.netlearning.framework.domain.ucenter.ext.UserExt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 11:52
 */
@Api(value = "用户中心",description = "用户中心管理")
public interface UserControllerApi {
    @ApiOperation("根据用户账号查询用户信息")
    public UserExt getUserext(@RequestParam("username") String username);
}

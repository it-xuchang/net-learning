package com.netlearning.api.userAuth;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.UserRole;
import com.netlearning.framework.domain.userAuth.UserRoleResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/23 10:53
 */
@Api(value = "用户角色管理",description = "用户角色管理")
public interface UserRoleControllerApi {
    public CommonResult<List<UserRoleResult>> query(@RequestParam(value = "userId",required = false) Long userId);

    public CommonResult<Boolean> add(@RequestBody UserRole userRole);

    public CommonResult<Boolean> edit(@RequestBody UserRole userRole);

    public CommonResult<Boolean> delete(UserRole userRole);
}

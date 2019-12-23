package com.netlearning.api.userAuth;

import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.LoginLog;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/23 10:50
 */
@Api(value = "用户登录日志管理",description = "用户登录日志管理")
public interface LoginLogControllerApi {

    public CommonResult<List<LoginLog>> query(@RequestParam(value = "username",required = false) String username,
                                              @RequestParam(value = "startLoginTime",required = false) String startLoginTime,
                                              @RequestParam(value = "endLoginTime",required = false) String endLoginTime,
                                              @RequestParam(value = "location",required = false) String location,
                                              @RequestParam(value = "ip",required = false) String ip);

    public CommonResult<CommonPageResult<LoginLog>> page(@RequestParam(value = "username",required = false) String username,
                                                         @RequestParam(value = "startLoginTime",required = false) String startLoginTime,
                                                         @RequestParam(value = "endLoginTime",required = false) String endLoginTime,
                                                         @RequestParam(value = "location",required = false) String location,
                                                         @RequestParam(value = "ip",required = false) String ip,
                                                         @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                         @RequestParam(value = "pageSize",required = false) Integer pageSize);

    public CommonResult<Boolean> add(@RequestBody LoginLog log);

    public CommonResult<Boolean> edit(@RequestBody LoginLog log);

    public CommonResult<Boolean> delete(LoginLog log);
}

package com.netlearning.api.userAuth;

import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.User;
import com.netlearning.framework.domain.userAuth.UserAddRequest;
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
@Api(value = "用户管理",description = "用户管理")
public interface UserControllerApi {
    public CommonResult<List<User>> query(@RequestParam(value = "userId",required = false) Long userId,
                                          @RequestParam(value = "userIds",required = false) List<Long> userIds,
                                          @RequestParam(value = "username",required = false) String username,
                                          @RequestParam(value = "email",required = false) String email,
                                          @RequestParam(value = "password",required = false) String password,
                                          @RequestParam(value = "mobile",required = false) String mobile,
                                          @RequestParam(value = "status",required = false) String status,
                                          @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                          @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                          @RequestParam(value = "sex",required = false) String sex,
                                          @RequestParam(value = "description",required = false) String description,
                                          @RequestParam(value = "avatar",required = false) String avatar,
                                          @RequestParam(value = "deptId",required = false) Long deptId);

    public CommonResult<CommonPageResult<User>> page(@RequestParam(value = "userId",required = false) Long userId,
                                                     @RequestParam(value = "username",required = false) String username,
                                                     @RequestParam(value = "email",required = false) String email,
                                                     @RequestParam(value = "password",required = false) String password,
                                                     @RequestParam(value = "mobile",required = false) String mobile,
                                                     @RequestParam(value = "status",required = false) String status,
                                                     @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                                     @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                                     @RequestParam(value = "sex",required = false) String sex,
                                                     @RequestParam(value = "description",required = false) String description,
                                                     @RequestParam(value = "avatar",required = false) String avatar,
                                                     @RequestParam(value = "deptId",required = false) Long deptId,
                                                     @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize);

    public CommonResult<Boolean> add(@RequestBody UserAddRequest user);

    public CommonResult<Boolean> edit(@RequestBody User user);

    public CommonResult<Boolean> delete(Long userId);
}

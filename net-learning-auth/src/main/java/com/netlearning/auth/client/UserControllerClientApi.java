package com.netlearning.auth.client;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.userAuth.User;
import com.netlearning.framework.domain.userAuth.UserAddRequest;
import com.netlearning.framework.domain.userAuth.result.UserResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/11 15:42
 */
@Component
@FeignClient(value = NetLearningServiceList.NET_LEARNING_USER_AUTH)
public interface UserControllerClientApi {

    @GetMapping("/user/query")
    public CommonResult<List<UserResult>> queryByEmail(@RequestParam(value = "email",required = false) String email,
                                                       @RequestParam(value = "password",required = false) String password);

    @GetMapping("/user/query")
    public CommonResult<List<UserResult>> queryByMobile( @RequestParam(value = "mobile",required = false) String mobile,
                                                         @RequestParam(value = "password",required = false) String password);

    @PostMapping("/user/add")
    public CommonResult<Boolean> add(@RequestBody UserAddRequest user);

    @PostMapping("/user/edit")
    public CommonResult<Boolean> edit(@RequestBody User user);

}

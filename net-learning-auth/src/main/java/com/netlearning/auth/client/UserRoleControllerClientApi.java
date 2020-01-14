package com.netlearning.auth.client;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.userAuth.UserRoleResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/13 19:17
 */
@Component
@FeignClient(value = NetLearningServiceList.NET_LEARNING_USER_AUTH)
public interface UserRoleControllerClientApi {

    @GetMapping("/user/role/query")
    public CommonResult<List<UserRoleResult>> query(@RequestParam(value = "userId",required = false) Long userId);
}

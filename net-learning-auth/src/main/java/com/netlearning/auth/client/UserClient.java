package com.netlearning.auth.client;

import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.ucenter.ext.UserExt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 14:55
 */
@FeignClient(value = NetLearningServiceList.NET_LEARNING_UCENTER)
public interface UserClient {
    //根据账号查询用户信息
    @GetMapping("/ucenter/getuserext")
    public UserExt getUserext(@RequestParam("username") String username);
}

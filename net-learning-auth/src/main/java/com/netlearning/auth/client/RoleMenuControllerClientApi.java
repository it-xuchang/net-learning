package com.netlearning.auth.client;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.userAuth.MenuItem;
import com.netlearning.framework.domain.userAuth.RoleMenu;
import com.netlearning.framework.domain.userAuth.RoleMenuRequest;
import com.netlearning.framework.domain.userAuth.RoleMenuResult;
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
 * @time: 2020/1/14 10:32
 */
@Component
@FeignClient(value = NetLearningServiceList.NET_LEARNING_USER_AUTH)
public interface RoleMenuControllerClientApi {

    @GetMapping("/role/menu/query")
    public CommonResult<RoleMenuResult> query(@RequestParam(value = "roleId",required = false) Long roleId);

    @GetMapping("/role/menu/tree")
    public CommonResult<List<MenuItem>> tree(@RequestParam(value = "roleId",required = false) Long roleId);

    @PostMapping("/role/menu/add")
    public CommonResult<Boolean> add(@RequestBody RoleMenuRequest roleMenu);

    @PostMapping("/role/menu/edit")
    public CommonResult<Boolean> edit(@RequestBody RoleMenu roleMenu);

    @PostMapping("/role/menu/delete")
    public CommonResult<Boolean> delete(RoleMenu roleMenu);
}

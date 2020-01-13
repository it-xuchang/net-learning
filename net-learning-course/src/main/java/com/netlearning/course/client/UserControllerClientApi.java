package com.netlearning.course.client;

import com.netlearning.api.ucenter.UserControllerApi;
import com.netlearning.api.userAuth.TeacherControllerApi;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.userAuth.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
 * produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；
 * @author: XUCHANG
 * @time: 2020/1/7 13:40
 */
@Component
@FeignClient(value=NetLearningServiceList.USER_AUTH_CENTER)
public interface UserControllerClientApi {
    @GetMapping(value = "/user/query/detail",produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public CommonResult<List<User>> queryByUserIds(@RequestParam(value = "userIds",required = false) List<Long> userIds);

}

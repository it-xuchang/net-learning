package com.netlearning.course.client;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.userAuth.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/7 19:02
 */
@Component
@FeignClient(value = NetLearningServiceList.USER_AUTH_CENTER)
public interface TeacherControllerClientApi {

    @GetMapping("/teacher/query")
    public CommonResult<List<Teacher>> query(@RequestParam(value = "teacherId",required = false) Long teacherId);

}

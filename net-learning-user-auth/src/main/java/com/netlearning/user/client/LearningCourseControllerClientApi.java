package com.netlearning.user.client;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.course.result.UserLearningCourseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/8 11:05
 */
@Component
@FeignClient(value= NetLearningServiceList.COURSE_CENTER)
public interface LearningCourseControllerClientApi {

    @GetMapping("/learning/course/query")
    public CommonResult<UserLearningCourseResult> query(@RequestParam(value = "userId",required = false) Long userId);
}

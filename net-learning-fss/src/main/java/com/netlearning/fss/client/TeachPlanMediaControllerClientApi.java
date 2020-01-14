package com.netlearning.fss.client;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.course.param.TeachPlanMediaAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaEditParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/9 14:29
 */
@Component
@FeignClient(value = NetLearningServiceList.NET_LEARNING_COURSE)
public interface TeachPlanMediaControllerClientApi {

    @PostMapping("/techplan/media/add")
    public CommonResult<Boolean> add(@RequestBody TeachPlanMediaAddParam request);

    @PostMapping("/techplan/media/edit")
    public CommonResult<Boolean> edit(@RequestBody TeachPlanMediaEditParam request);

    @PostMapping("/techplan/media/delete")
    public CommonResult<Boolean> delete(@RequestBody List<Long> teachplanMediaIds);
}

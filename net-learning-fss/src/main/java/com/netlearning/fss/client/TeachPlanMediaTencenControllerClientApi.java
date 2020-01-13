package com.netlearning.fss.client;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentDeleteParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentEditParam;
import com.netlearning.framework.domain.course.result.TeachPlanMediaTencentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/10 14:35
 */
@Component
@FeignClient(value = NetLearningServiceList.COURSE_CENTER)
public interface TeachPlanMediaTencenControllerClientApi {
    @GetMapping("/techplan/media/tencent/query")
    public CommonResult<List<TeachPlanMediaTencentResult>> query(@RequestParam(value = "teachplanMediaTencentId",required = false) Long teachplanMediaTencentId,
                                                                 @RequestParam(value = "teachplanMediaId",required = false) Long teachplanMediaId);

    @RequestMapping("/techplan/media/tencent/add")
    public CommonResult<Boolean> add(TeachPlanMediaTencentAddParam param);

    @RequestMapping("/techplan/media/tencent/edit")
    public CommonResult<Boolean> edit(TeachPlanMediaTencentEditParam param);

    @RequestMapping("/techplan/media/tencent/delete")
    public CommonResult<Boolean> delete(TeachPlanMediaTencentDeleteParam param);
}

package com.netlearning.course.client;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.fss.result.FileRecordImagesResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/10 16:11
 */
@Component
@FeignClient(value = NetLearningServiceList.NET_LEARNING_FSS)
public interface FileRecordImagesControllerClientApi {
    @GetMapping("/file/record/images/query")
    public CommonResult<List<FileRecordImagesResult>> query(@RequestParam(value = "fromSystemIds",required = false) List<Long> fromSystemIds);


}

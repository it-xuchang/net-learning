package com.netlearning.course.client;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.fss.param.FileRecordDowmloadParam;
import com.netlearning.framework.domain.fss.param.FileRecordRemoveParam;
import com.netlearning.framework.domain.fss.result.FileRecordResourcesResult;
import com.netlearning.framework.domain.fss.result.FileRecordResult;
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
 * @time: 2020/1/10 16:11
 */
@Component
@FeignClient(value = NetLearningServiceList.NET_LEARNING_FSS)
public interface FileRecordResourcesControllerClientApi {
    @GetMapping("/file/record/resources/query")
    public CommonResult<List<FileRecordResourcesResult>> query(@RequestParam(value = "fromSystemIds",required = false) List<Long> fromSystemIds);
}

package com.netlearning.user.client;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.fss.param.FileRecordDowmloadParam;
import com.netlearning.framework.domain.fss.param.FileRecordRemoveParam;
import com.netlearning.framework.domain.fss.result.FileRecordResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/10 16:11
 */
@Component
@FeignClient(value = NetLearningServiceList.NET_LEARNING_FSS)
public interface FileRecordControllerClientApi {

    @GetMapping("/file/record/query")
    public CommonResult<List<FileRecordResult>> query(@RequestParam(value = "recordId",required = false) Long recordId,
                                                      @RequestParam(value = "recordIds",required = false) List<Long> recordIds,
                                                      @RequestParam(value = "fromSystemId" ,required = false) Long fromSystemId,
                                                      @RequestParam(value = "fromSystemIds" ,required = false) List<Long> fromSystemIds );

    @GetMapping("/file/record/query")
    public CommonResult<List<FileRecordResult>> queryByRecordIds(@RequestParam(value = "recordIds",required = false) List<Long> recordIds);

    @GetMapping("/file/record/query")
    public CommonResult<List<FileRecordResult>> queryByFromSystemIds(@RequestParam(value = "fromSystemIds" ,required = false) List<Long> fromSystemIds);

    @PostMapping("/file/record/download")
    public CommonResult download(@RequestBody FileRecordDowmloadParam param);

    @PostMapping("/file/record/remove")
    public CommonResult remove(@RequestBody FileRecordRemoveParam param);
}

package com.netlearning.api.userAuth;

import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.Log;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/23 10:49
 */
@Api(value = "日志管理",description = "日志管理")
public interface LogControllerApi {
    public CommonResult<List<Log>> query(@RequestParam(value = "id",required = false) Long id,
                                         @RequestParam(value = "username",required = false) String username,
                                         @RequestParam(value = "time",required = false) Long time,
                                         @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                         @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                         @RequestParam(value = "location",required = false) String location,
                                         @RequestParam(value = "ip",required = false) String ip);

    public CommonResult<CommonPageResult<Log>> page(@RequestParam(value = "id",required = false) Long id,
                                                    @RequestParam(value = "username",required = false) String username,
                                                    @RequestParam(value = "time",required = false) Long time,
                                                    @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                                    @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                                    @RequestParam(value = "location",required = false) String location,
                                                    @RequestParam(value = "ip",required = false) String ip,
                                                    @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                    @RequestParam(value = "pageSize",required = false) Integer pageSize);

    public CommonResult<Boolean> add(@RequestBody Log log);

    public CommonResult<Boolean> edit(@RequestBody Log log);

    public CommonResult<Boolean> delete(Long id);

}

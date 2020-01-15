package com.netlearning.user.controller;

import com.netlearning.api.userAuth.LogControllerApi;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.framework.domain.userAuth.Log;
import com.netlearning.framework.domain.userAuth.LogParam;
import com.netlearning.user.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:36
 */
@RestController
@RequestMapping("/log")
public class LogController implements LogControllerApi {

    @Autowired
    private LogService logService;

    @Override
    @GetMapping("/query")
    public CommonResult<List<Log>> query(@RequestParam(value = "id",required = false) Long id,
                                         @RequestParam(value = "username",required = false) String username,
                                         @RequestParam(value = "time",required = false) Long time,
                                         @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                         @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                         @RequestParam(value = "location",required = false) String location,
                                         @RequestParam(value = "ip",required = false) String ip){
        LogParam logParam = new LogParam();
        logParam.setEndCreateTime(endCreateTime);
        logParam.setId(id);
        logParam.setLocation(location);
        logParam.setIp(ip);
        logParam.setStartCreateTime(startCreateTime);
        logParam.setTime(time);
        logParam.setUsername(username);

        return logService.query(logParam);
    }
    @Override
    @GetMapping("/page")
    public CommonResult<CommonPageResult<Log>> page(@RequestParam(value = "id",required = false) Long id,
                                                     @RequestParam(value = "username",required = false) String username,
                                                     @RequestParam(value = "time",required = false) Long time,
                                                     @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                                     @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                                     @RequestParam(value = "location",required = false) String location,
                                                     @RequestParam(value = "ip",required = false) String ip,
                                                     @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        LogParam logParam = new LogParam();
        logParam.setEndCreateTime(endCreateTime);
        logParam.setId(id);
        logParam.setLocation(location);
        logParam.setIp(ip);
        logParam.setStartCreateTime(startCreateTime);
        logParam.setTime(time);
        logParam.setUsername(username);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return logService.page(logParam,commonPageInfo);
    }

    @Override
    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody Log log){
        return logService.add(log);
    }

    @Override
    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody Log log){
        return logService.edit(log);
    }

    @Override
    @PostMapping("/delete")
    public CommonResult<Boolean> delete(Long id){
        return logService.delete(id);
    }

}

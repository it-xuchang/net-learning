package com.netlearning.user.controller;

import com.netlearning.api.userAuth.LoginLogControllerApi;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.framework.domain.userAuth.LoginLog;
import com.netlearning.framework.domain.userAuth.LoginLogParam;
import com.netlearning.user.service.LoginLogService;
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
@RequestMapping("/login/log")
public class LoginLogController implements LoginLogControllerApi {
    @Autowired
    private LoginLogService loginLogService;

    @Override
    @GetMapping("query")
    public CommonResult<List<LoginLog>> query(@RequestParam(value = "username",required = false) String username,
                                              @RequestParam(value = "startLoginTime",required = false) String startLoginTime,
                                              @RequestParam(value = "endLoginTime",required = false) String endLoginTime,
                                              @RequestParam(value = "location",required = false) String location,
                                              @RequestParam(value = "ip",required = false) String ip){
        LoginLogParam logParam = new LoginLogParam();
        logParam.setStartLoginTime(startLoginTime);
        logParam.setLocation(location);
        logParam.setIp(ip);
        logParam.setEndLoginTime(endLoginTime);
        logParam.setUsername(username);

        return loginLogService.query(logParam);
    }
    @Override
    @GetMapping("page")
    public CommonResult<CommonPageResult<LoginLog>> page(@RequestParam(value = "username",required = false) String username,
                                                         @RequestParam(value = "startLoginTime",required = false) String startLoginTime,
                                                         @RequestParam(value = "endLoginTime",required = false) String endLoginTime,
                                                         @RequestParam(value = "location",required = false) String location,
                                                         @RequestParam(value = "ip",required = false) String ip,
                                                         @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                         @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        LoginLogParam logParam = new LoginLogParam();
        logParam.setStartLoginTime(startLoginTime);
        logParam.setLocation(location);
        logParam.setIp(ip);
        logParam.setEndLoginTime(endLoginTime);
        logParam.setUsername(username);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return loginLogService.page(logParam,commonPageInfo);
    }

    @Override
    @PostMapping("add")
    public CommonResult<Boolean> add(@RequestBody LoginLog log){
        return loginLogService.add(log);
    }

    @Override
    @PostMapping("edit")
    public CommonResult<Boolean> edit(@RequestBody LoginLog log){
        return loginLogService.edit(log);
    }

    @Override
    @DeleteMapping("delete")
    public CommonResult<Boolean> delete(LoginLog log){
        return loginLogService.delete(log);
    }
}

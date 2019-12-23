package com.netlearning.user.controller;

import com.netlearning.api.userAuth.UserConfigControllerApi;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.framework.domain.userAuth.UserConfig;
import com.netlearning.framework.domain.userAuth.UserConfigParam;
import com.netlearning.user.service.UserConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:25
 */
@RestController
@RequestMapping("/user/config")
public class UserConfigController implements UserConfigControllerApi {
    @Autowired
    private UserConfigService userConfigService;

    @Override
    @GetMapping("query")
    public CommonResult<List<UserConfig>> query(@RequestParam(value = "userId",required = false) Long userId,
                                                @RequestParam(value = "theme",required = false) String theme,
                                                @RequestParam(value = "layout",required = false) String layout,
                                                @RequestParam(value = "multiPage",required = false) String multiPage,
                                                @RequestParam(value = "fixSiderbar",required = false) String fixSiderbar,
                                                @RequestParam(value = "fixHeader",required = false) String fixHeader,
                                                @RequestParam(value = "color",required = false) String color){
        UserConfigParam userConfigParam = new UserConfigParam();
        userConfigParam.setColor(color);
        userConfigParam.setFixHeader(fixHeader);
        userConfigParam.setFixSiderbar(fixSiderbar);
        userConfigParam.setLayout(layout);
        userConfigParam.setMultiPage(multiPage);
        userConfigParam.setTheme(theme);
        userConfigParam.setUserId(userId);
        return userConfigService.query(userConfigParam);
    }
    @Override
    @GetMapping("page")
    public CommonResult<CommonPageResult<UserConfig>> page(@RequestParam(value = "userId",required = false) Long userId,
                                                           @RequestParam(value = "theme",required = false) String theme,
                                                           @RequestParam(value = "layout",required = false) String layout,
                                                           @RequestParam(value = "multiPage",required = false) String multiPage,
                                                           @RequestParam(value = "fixSiderbar",required = false) String fixSiderbar,
                                                           @RequestParam(value = "fixHeader",required = false) String fixHeader,
                                                           @RequestParam(value = "color",required = false) String color,
                                                           @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                           @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        UserConfigParam userConfigParam = new UserConfigParam();
        userConfigParam.setColor(color);
        userConfigParam.setFixHeader(fixHeader);
        userConfigParam.setFixSiderbar(fixSiderbar);
        userConfigParam.setLayout(layout);
        userConfigParam.setMultiPage(multiPage);
        userConfigParam.setTheme(theme);
        userConfigParam.setUserId(userId);

        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return userConfigService.page(userConfigParam,commonPageInfo);
    }

    @Override
    @PostMapping("add")
    public CommonResult<Boolean> add(@RequestBody UserConfig userConfig){
        return userConfigService.add(userConfig);
    }

    @Override
    @PostMapping("edit")
    public CommonResult<Boolean> edit(@RequestBody UserConfig userConfig){
        return userConfigService.edit(userConfig);
    }

    @Override
    @DeleteMapping("delete")
    public CommonResult<Boolean> delete(Long userId){
        return userConfigService.delete(userId);
    }

}

package com.netlearning.api.userAuth;

import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.UserConfig;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/23 10:52
 */
@Api(value = "用户配置管理",description = "用户配置管理")
public interface UserConfigControllerApi {

    public CommonResult<List<UserConfig>> query(@RequestParam(value = "userId",required = false) Long userId,
                                                @RequestParam(value = "theme",required = false) String theme,
                                                @RequestParam(value = "layout",required = false) String layout,
                                                @RequestParam(value = "multiPage",required = false) String multiPage,
                                                @RequestParam(value = "fixSiderbar",required = false) String fixSiderbar,
                                                @RequestParam(value = "fixHeader",required = false) String fixHeader,
                                                @RequestParam(value = "color",required = false) String color);

    public CommonResult<CommonPageResult<UserConfig>> page(@RequestParam(value = "userId",required = false) Long userId,
                                                           @RequestParam(value = "theme",required = false) String theme,
                                                           @RequestParam(value = "layout",required = false) String layout,
                                                           @RequestParam(value = "multiPage",required = false) String multiPage,
                                                           @RequestParam(value = "fixSiderbar",required = false) String fixSiderbar,
                                                           @RequestParam(value = "fixHeader",required = false) String fixHeader,
                                                           @RequestParam(value = "color",required = false) String color,
                                                           @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                           @RequestParam(value = "pageSize",required = false) Integer pageSize);

    public CommonResult<Boolean> add(@RequestBody UserConfig userConfig);

    public CommonResult<Boolean> edit(@RequestBody UserConfig userConfig);

    public CommonResult<Boolean> delete(Long userId);
}

package com.netlearning.api.userAuth;

import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.Menu;
import com.netlearning.framework.domain.userAuth.MenuItem;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/23 10:50
 */
@Api(value = "菜单管理",description = "菜单管理")
public interface MenuControllerApi {

    public CommonResult<List<Menu>> query(@RequestParam(value = "menuId",required = false) Long menuId,
                                          @RequestParam(value = "parentId",required = false) Long parentId,
                                          @RequestParam(value = "menuName",required = false) String menuName,
                                          @RequestParam(value = "path",required = false) String path,
                                          @RequestParam(value = "component",required = false) String component,
                                          @RequestParam(value = "perms",required = false) String perms,
                                          @RequestParam(value = "icon",required = false) String icon,
                                          @RequestParam(value = "type",required = false) String type,
                                          @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                          @RequestParam(value = "endCreateTime",required = false) String endCreateTime);

    public CommonResult<CommonPageResult<Menu>> page(@RequestParam(value = "menuId",required = false) Long menuId,
                                                     @RequestParam(value = "parentId",required = false) Long parentId,
                                                     @RequestParam(value = "menuName",required = false) String menuName,
                                                     @RequestParam(value = "path",required = false) String path,
                                                     @RequestParam(value = "component",required = false) String component,
                                                     @RequestParam(value = "perms",required = false) String perms,
                                                     @RequestParam(value = "icon",required = false) String icon,
                                                     @RequestParam(value = "type",required = false) String type,
                                                     @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                                     @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                                     @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize);

    public CommonResult<List<MenuItem>> tree(@RequestParam(value = "menuId",required = false) Long menuId,
                                             @RequestParam(value = "parentId",required = false) Long parentId,
                                             @RequestParam(value = "menuName",required = false) String menuName,
                                             @RequestParam(value = "path",required = false) String path,
                                             @RequestParam(value = "component",required = false) String component,
                                             @RequestParam(value = "perms",required = false) String perms,
                                             @RequestParam(value = "icon",required = false) String icon,
                                             @RequestParam(value = "type",required = false) String type,
                                             @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                             @RequestParam(value = "endCreateTime",required = false) String endCreateTime);

    public CommonResult<Boolean> add(@RequestBody Menu menu);

    public CommonResult<Boolean> edit(@RequestBody Menu menu);

    public CommonResult<Boolean> delete(Long menuId);

}

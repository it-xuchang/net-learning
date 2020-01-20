package com.netlearning.user.controller;

import com.netlearning.api.userAuth.MenuControllerApi;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.param.MenuAddParam;
import com.netlearning.framework.domain.userAuth.param.MenuDeleteParam;
import com.netlearning.framework.domain.userAuth.param.MenuEditParam;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.framework.domain.userAuth.Menu;
import com.netlearning.framework.domain.userAuth.MenuItem;
import com.netlearning.framework.domain.userAuth.MenuParam;
import com.netlearning.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:44
 */
@RequestMapping("/menu")
@RestController
public class MenuController implements MenuControllerApi {
    @Autowired
    private MenuService menuService;

    @Override
    @GetMapping("/query")
    public CommonResult<List<Menu>> query(@RequestParam(value = "menuId",required = false) Long menuId,
                                          @RequestParam(value = "parentId",required = false) Long parentId,
                                          @RequestParam(value = "menuName",required = false) String menuName,
                                          @RequestParam(value = "path",required = false) String path,
                                          @RequestParam(value = "component",required = false) String component,
                                          @RequestParam(value = "perms",required = false) String perms,
                                          @RequestParam(value = "icon",required = false) String icon,
                                          @RequestParam(value = "type",required = false) String type,
                                          @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                          @RequestParam(value = "endCreateTime",required = false) String endCreateTime){
        MenuParam menu = new MenuParam();
        menu.setMenuId(menuId);
        menu.setParentId(parentId);
        menu.setEndCreateTime(endCreateTime);
        menu.setStartCreateTime(startCreateTime);
        menu.setMenuName(menuName);
        menu.setComponent(component);
        menu.setPath(path);
        menu.setPerms(perms);
        menu.setType(type);
        menu.setIcon(icon);
        return menuService.query(menu);
    }
    @Override
    @GetMapping("/page")
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
                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        MenuParam menu = new MenuParam();
        menu.setMenuId(menuId);
        menu.setParentId(parentId);
        menu.setEndCreateTime(endCreateTime);
        menu.setStartCreateTime(startCreateTime);
        menu.setMenuName(menuName);
        menu.setComponent(component);
        menu.setPath(path);
        menu.setPerms(perms);
        menu.setType(type);
        menu.setIcon(icon);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return menuService.page(menu,commonPageInfo);
    }

    @Override
    @GetMapping("/tree")
    public CommonResult<List<MenuItem>> tree(@RequestParam(value = "menuId",required = false) Long menuId,
                                             @RequestParam(value = "parentId",required = false) Long parentId,
                                             @RequestParam(value = "menuName",required = false) String menuName,
                                             @RequestParam(value = "path",required = false) String path,
                                             @RequestParam(value = "component",required = false) String component,
                                             @RequestParam(value = "perms",required = false) String perms,
                                             @RequestParam(value = "icon",required = false) String icon,
                                             @RequestParam(value = "type",required = false) String type,
                                             @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                             @RequestParam(value = "endCreateTime",required = false) String endCreateTime){
        MenuParam menu = new MenuParam();
        menu.setMenuId(menuId);
        menu.setParentId(parentId);
        menu.setEndCreateTime(endCreateTime);
        menu.setStartCreateTime(startCreateTime);
        menu.setMenuName(menuName);
        menu.setComponent(component);
        menu.setPath(path);
        menu.setPerms(perms);
        menu.setType(type);
        menu.setIcon(icon);
        return menuService.tree(menu);
    }
    @Override
    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody MenuAddParam menuAddParam){
        return menuService.add(menuAddParam);
    }

    @Override
    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody MenuEditParam menuEditParam){
        return menuService.edit(menuEditParam);
    }

    @Override
    @PostMapping("/delete")
    public CommonResult<Boolean> delete(@RequestBody MenuDeleteParam menuDeleteParam){
        return menuService.delete(menuDeleteParam);
    }
}

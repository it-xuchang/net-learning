package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.userAuth.param.MenuAddParam;
import com.netlearning.framework.domain.userAuth.param.MenuDeleteParam;
import com.netlearning.framework.domain.userAuth.param.MenuEditParam;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.DateUtils;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.mapper.MenuMapper;
import com.netlearning.framework.domain.userAuth.Menu;
import com.netlearning.framework.domain.userAuth.MenuExample;
import com.netlearning.framework.domain.userAuth.MenuItem;
import com.netlearning.framework.domain.userAuth.MenuParam;
import com.netlearning.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:48
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    protected SequenceService sequenceService;
    @Autowired
    private RoleMenuServiceImpl roleMenuService;
    @Override
    public CommonResult<List<Menu>> query(MenuParam menu) {

        MenuExample example = this.getMenuExample(menu);
        List<Menu> result = menuMapper.selectByExample(example);
        return CommonResult.success(result);
    }

    private MenuExample getMenuExample(MenuParam menu) {
        MenuExample example = new MenuExample();
        example.setOrderByClause("CREATE_TIME desc");
        MenuExample.Criteria criteria = example.createCriteria();
        if (menu.getMenuId() != null){
            criteria.andMenuIdEqualTo(menu.getMenuId());
        }
        if (menu.getParentId() != null){
            criteria.andParentIdEqualTo(menu.getParentId());
        }
        if (!StringUtils.isEmpty(menu.getMenuName())){
            criteria.andMenuNameLike("%"+menu.getMenuName()+"%");
        }
        if (!StringUtils.isEmpty(menu.getPath())){
            criteria.andPathEqualTo(menu.getPath());
        }
        if (!StringUtils.isEmpty(menu.getType())){
            criteria.andTypeEqualTo(menu.getType());
        }
        if (!StringUtils.isEmpty(menu.getComponent())){
            criteria.andTypeEqualTo(menu.getComponent());
        }
        if (!StringUtils.isEmpty(menu.getPerms())){
            criteria.andTypeEqualTo(menu.getPerms());
        }
        if (!StringUtils.isEmpty(menu.getIcon())){
            criteria.andTypeEqualTo(menu.getIcon());
        }
        if(!StringUtils.isEmpty(menu.getStartCreateTime()) && !StringUtils.isEmpty(menu.getEndCreateTime())){
            criteria.andCreateTimeBetween(DateUtils.parseDate(menu.getStartCreateTime()),DateUtils.parseDate(menu.getEndCreateTime()));
        }
        return example;
    }

    @Override
    public CommonResult<CommonPageResult<Menu>> page(MenuParam menu, CommonPageInfo commonPageInfo) {
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        MenuExample example = this.getMenuExample(menu);
        Page<Menu> result = (Page<Menu>) menuMapper.selectByExample(example);
        CommonPageResult<Menu> pageResult = CommonPageResult.build(result,commonPageInfo,result.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(MenuAddParam menuAddParam) {
        try {
            Menu record = new Menu();
            BeanCopyUtils.copyProperties(menuAddParam,record);
            record.setMenuId(sequenceService.nextValue(null));
            record.setCreateTime(new Date());
            menuMapper.insertSelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE002.code,ExceptionCode.UserAuthCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(MenuEditParam menuEditParam) {
        try {
            Menu record = new Menu();
            BeanCopyUtils.copyProperties(menuEditParam,record);
            record.setModifyTime(new Date());
            menuMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(MenuDeleteParam menuDeleteParam) {
        try {
            MenuExample example = new MenuExample();
            MenuExample.Criteria criteria = example.createCriteria();
            if (!CollectionUtils.isEmpty(menuDeleteParam.getMenuIds())){
                criteria.andMenuIdIn(menuDeleteParam.getMenuIds());
            }
            menuMapper.deleteByExample(example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<List<MenuItem>> tree(MenuParam menu) {
        MenuExample example = this.getMenuExample(menu);
        List<Menu> result = menuMapper.selectByExample(example);
        List<MenuItem> menuItemList = roleMenuService.getRoleTreeMenu(result);
        return CommonResult.success(menuItemList);
    }
}

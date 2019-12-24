package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.userAuth.*;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.DateUtils;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.mapper.RoleMapper;
import com.netlearning.user.mapper.RoleMenuMapper;
import com.netlearning.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 16:49
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public CommonResult<List<Role>> query(RoleParam roleParam) {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if (roleParam.getRoleId() != null){
            criteria.andRoleIdEqualTo(roleParam.getRoleId());
        }
        if (!StringUtils.isEmpty(roleParam.getRemark())){
            criteria.andRemarkLike("%"+roleParam.getRemark()+"%");
        }
        if (!StringUtils.isEmpty(roleParam.getRoleName())){
            criteria.andRoleNameLike("%"+roleParam.getRoleName()+"%");
        }
        if(!StringUtils.isEmpty(roleParam.getStartCreateTime()) && !StringUtils.isEmpty(roleParam.getEndCreateTime())){
            criteria.andCreateTimeBetween(DateUtils.parseDate(roleParam.getStartCreateTime()),DateUtils.parseDate(roleParam.getEndCreateTime()));
        }
        List<Role> reult  = roleMapper.selectByExample(example);

        return CommonResult.success(reult);
    }

    @Override
    public CommonResult<CommonPageResult<Role>> page(RoleParam roleParam, CommonPageInfo commonPageInfo) {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if (roleParam.getRoleId() != null){
            criteria.andRoleIdEqualTo(roleParam.getRoleId());
        }
        if (!StringUtils.isEmpty(roleParam.getRemark())){
            criteria.andRemarkLike("%"+roleParam.getRemark()+"%");
        }
        if (!StringUtils.isEmpty(roleParam.getRoleName())){
            criteria.andRoleNameLike("%"+roleParam.getRoleName()+"%");
        }
        if(!StringUtils.isEmpty(roleParam.getStartCreateTime()) && !StringUtils.isEmpty(roleParam.getEndCreateTime())){
            criteria.andCreateTimeBetween(DateUtils.parseDate(roleParam.getStartCreateTime()),DateUtils.parseDate(roleParam.getEndCreateTime()));
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<Role> reult  = (Page<Role>) roleMapper.selectByExample(example);
        CommonPageResult<Role> pageResult = CommonPageResult.build(reult.getResult(),commonPageInfo,reult.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public CommonResult<Boolean> add(RoleAddRequest roleAddRequest) {
        try {
            Role role = new Role();
            Long roleId = sequenceService.nextValue(null);
            BeanCopyUtils.copyProperties(roleAddRequest,role);
            role.setRoleId(roleId);
            role.setCreateTime(new Date());
            roleMapper.insertSelective(role);
            List<RoleMenu> roleMenus = new ArrayList<>();
            for (Long menuId : roleAddRequest.getMenuIds()){
                RoleMenu menu = new RoleMenu();
                menu.setRoleId(roleId);
                menu.setMenuId(menuId);
                roleMenus.add(menu);
            }
            roleMenuMapper.mutipartInsertSelective(roleMenus);

            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE002.code,ExceptionCode.UserAuthCode.CODE002.message);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = {Exception.class})
    public CommonResult<Boolean> edit(RoleEditRequest roleEditRequest) {
        try {
            Role record = new Role();
            BeanCopyUtils.copyProperties(roleEditRequest,record);
            record.setModifyTime(new Date());

            roleMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE003.message);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = {Exception.class})
    public CommonResult<Boolean> delete(RoleDeleteRequest roleDeleteRequest) {
        try {
            roleMapper.deleteByPrimaryKey(roleDeleteRequest.getRoleId());
            if (!CollectionUtils.isEmpty(roleDeleteRequest.getMenuIds())){
                RoleMenuExample example = new RoleMenuExample();
                example.createCriteria().andRoleIdEqualTo(roleDeleteRequest.getRoleId()).andMenuIdIn(roleDeleteRequest.getMenuIds());
                roleMenuMapper.deleteByExample(example);
            }
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }
}

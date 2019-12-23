package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.DateUtils;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.mapper.RoleMapper;
import com.netlearning.framework.domain.userAuth.Role;
import com.netlearning.framework.domain.userAuth.RoleExample;
import com.netlearning.framework.domain.userAuth.RoleParam;
import com.netlearning.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public CommonResult<Boolean> add(Role role) {
        try {
            role.setRoleId(sequenceService.nextValue(null));
            role.setCreateTime(new Date());
            roleMapper.insertSelective(role);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE002.code,ExceptionCode.UserAuthCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(Role role) {
        try {
            role.setModifyTime(new Date());
            roleMapper.updateByPrimaryKeySelective(role);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(Long roleId) {
        try {
            roleMapper.deleteByPrimaryKey(roleId);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }
}

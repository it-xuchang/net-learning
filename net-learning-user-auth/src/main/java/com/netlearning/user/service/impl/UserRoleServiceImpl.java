package com.netlearning.user.service.impl;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.*;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.user.mapper.RoleMapper;
import com.netlearning.user.mapper.UserMapper;
import com.netlearning.user.mapper.UserRoleMapper;
import com.netlearning.user.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:31
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public CommonResult<List<UserRoleResult>> query(UserRole userRole) {

        UserRoleExample example =  new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(userRole.getRoleId());
        List<UserRole> result = userRoleMapper.selectByExample(example);
        List<UserRoleResult> userRoleResults = new ArrayList<>();
        if (!CollectionUtils.isEmpty(result)){
            RoleExample roleExample = new RoleExample();
            roleExample.createCriteria().andRoleIdEqualTo(userRole.getRoleId());
            List<Role> roleList = roleMapper.selectByExample(roleExample);
            if (!CollectionUtils.isEmpty(roleList)){
                UserRoleResult userRoleResult = new UserRoleResult();
                userRoleResult.setRole(roleList.get(0));
                userRoleResult.setUserId(userRole.getUserId());
                userRoleResults.add(userRoleResult);
            }
        }
        return CommonResult.success(userRoleResults);
    }


    @Override
    public CommonResult<Boolean> add(UserRole userRole) {
        UserRoleExample example =  new UserRoleExample();
        example.createCriteria()
                .andRoleIdEqualTo(userRole.getRoleId())
                .andUserIdEqualTo(userRole.getRoleId());
        List<UserRole> result = userRoleMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(result)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE013.code,ExceptionCode.UserAuthCode.CODE013.message);
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userRole.getUserId());
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE014.code,ExceptionCode.UserAuthCode.CODE014.message);
        }
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleIdEqualTo(userRole.getRoleId());
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        if (CollectionUtils.isEmpty(roleList)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE015.code,ExceptionCode.UserAuthCode.CODE015.message);
        }
        try {
            userRoleMapper.insertSelective(userRole);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE002.code,ExceptionCode.UserAuthCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(UserRole userRole) {
        UserRoleExample example =  new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(userRole.getRoleId());
        List<UserRole> result = userRoleMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(result)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE016.code,ExceptionCode.UserAuthCode.CODE016.message);
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userRole.getUserId());
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE014.code,ExceptionCode.UserAuthCode.CODE014.message);
        }
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleIdEqualTo(userRole.getRoleId());
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        if (CollectionUtils.isEmpty(roleList)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE015.code,ExceptionCode.UserAuthCode.CODE015.message);
        }
        try {
            UserRoleExample userRoleExample =  new UserRoleExample();
            userRoleExample.createCriteria().andUserIdEqualTo(userRole.getRoleId());
            userRoleMapper.updateByExampleSelective(userRole,example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(UserRole userRole) {
        try {
            UserRoleExample example =  new UserRoleExample();
            example.createCriteria()
                    .andRoleIdEqualTo(userRole.getRoleId())
                    .andUserIdEqualTo(userRole.getRoleId());
            userRoleMapper.deleteByExample(example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }
}

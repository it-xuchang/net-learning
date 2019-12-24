package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.userAuth.UserAddRequest;
import com.netlearning.framework.em.UserAuthConstants;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.DateUtils;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.mapper.UserMapper;
import com.netlearning.framework.domain.userAuth.User;
import com.netlearning.framework.domain.userAuth.UserExample;
import com.netlearning.framework.domain.userAuth.UserParam;
import com.netlearning.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 16:11
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    protected SequenceService sequenceService;
    @Override
    public CommonResult<List<User>> query(UserParam userParam) {
        UserExample example = new UserExample();
        example.setOrderByClause("CREATE_TIME desc");
        UserExample.Criteria criteria = example.createCriteria();
        if (userParam.getUserId() != null){
            criteria.andUserIdEqualTo(userParam.getUserId());
        }
        if (!StringUtils.isEmpty(userParam.getUsername())){
            criteria.andUsernameLike(userParam.getUsername());
        }
        if (!StringUtils.isEmpty(userParam.getPassword())){
            criteria.andPasswordEqualTo(userParam.getPassword());
        }
        if (userParam.getDeptId() != null){
            criteria.andDeptIdEqualTo(userParam.getDeptId());
        }
        if (!StringUtils.isEmpty(userParam.getEmail())){
            criteria.andEmailEqualTo(userParam.getEmail());
        }
        if (!StringUtils.isEmpty(userParam.getMobile())){
            criteria.andMobileEqualTo(userParam.getMobile());
        }
        if (!StringUtils.isEmpty(userParam.getStatus())){
            criteria.andStatusEqualTo(userParam.getStatus());
        }
        if (!StringUtils.isEmpty(userParam.getSex())){
            criteria.andSsexEqualTo(userParam.getSex());
        }
        if (!StringUtils.isEmpty(userParam.getDescription())){
            criteria.andDescriptionLike(userParam.getDescription());
        }
        if (!StringUtils.isEmpty(userParam.getAvatar())){
            criteria.andAvatarEqualTo(userParam.getAvatar());
        }
        if(!StringUtils.isEmpty(userParam.getStartCreateTime()) && !StringUtils.isEmpty(userParam.getEndCreateTime())){
            criteria.andCreateTimeBetween(DateUtils.parseDate(userParam.getStartCreateTime()),DateUtils.parseDate(userParam.getEndCreateTime()));
        }
        List<User> result = userMapper.selectByExample(example);
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<CommonPageResult<User>> page(UserParam userParam, CommonPageInfo commonPageInfo) {
        UserExample example = new UserExample();
        example.setOrderByClause("CREATE_TIME desc");
        UserExample.Criteria criteria = example.createCriteria();
        if (userParam.getUserId() != null){
            criteria.andUserIdEqualTo(userParam.getUserId());
        }
        if (!StringUtils.isEmpty(userParam.getUsername())){
            criteria.andUsernameLike(userParam.getUsername());
        }
        if (!StringUtils.isEmpty(userParam.getPassword())){
            criteria.andPasswordEqualTo(userParam.getPassword());
        }
        if (userParam.getDeptId() != null){
            criteria.andDeptIdEqualTo(userParam.getDeptId());
        }
        if (!StringUtils.isEmpty(userParam.getEmail())){
            criteria.andEmailEqualTo(userParam.getEmail());
        }
        if (!StringUtils.isEmpty(userParam.getMobile())){
            criteria.andMobileEqualTo(userParam.getMobile());
        }
        if (!StringUtils.isEmpty(userParam.getStatus())){
            criteria.andStatusEqualTo(userParam.getStatus());
        }
        if (!StringUtils.isEmpty(userParam.getSex())){
            criteria.andSsexEqualTo(userParam.getSex());
        }
        if (!StringUtils.isEmpty(userParam.getDescription())){
            criteria.andDescriptionLike(userParam.getDescription());
        }
        if (!StringUtils.isEmpty(userParam.getAvatar())){
            criteria.andAvatarEqualTo(userParam.getAvatar());
        }
        if(!StringUtils.isEmpty(userParam.getStartCreateTime()) && !StringUtils.isEmpty(userParam.getEndCreateTime())){
            criteria.andCreateTimeBetween(DateUtils.parseDate(userParam.getStartCreateTime()),DateUtils.parseDate(userParam.getEndCreateTime()));
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<User> result = (Page<User>) userMapper.selectByExample(example);
        CommonPageResult<User> pageResult = CommonPageResult.build(result.getResult(),commonPageInfo,result.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(UserAddRequest user) {
        try {

            if (!UserAuthConstants.UserSexType.userSexTypeList().contains(user.getSsex()) && !StringUtils.isEmpty(user.getSsex())){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE012.code,ExceptionCode.UserAuthCode.CODE012.message);
            }
            User record = new User();
            BeanCopyUtils.copyProperties(user,record);
            record.setUserId(sequenceService.nextValue(null));
            record.setStatus(UserAuthConstants.UserType.UP.getCode());
            record.setCreateTime(new Date());
            if (StringUtils.isEmpty(user.getSsex())){
                record.setSsex(UserAuthConstants.UserSexType.NON.getCode());
            }
            if (user.getRoleId() != null){

            }
            userMapper.insertSelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE002.code,ExceptionCode.UserAuthCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(User user) {
        try {
            if (!UserAuthConstants.UserType.userTypeList().contains(user.getStatus())){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE011.code,ExceptionCode.UserAuthCode.CODE011.message);
            }
            if (!UserAuthConstants.UserSexType.userSexTypeList().contains(user.getSsex())){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE012.code,ExceptionCode.UserAuthCode.CODE012.message);
            }
            userMapper.updateByPrimaryKeySelective(user);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(Long userId) {
        try {
            userMapper.deleteByPrimaryKey(userId);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }
}

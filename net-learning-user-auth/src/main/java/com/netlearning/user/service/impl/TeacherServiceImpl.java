package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.userAuth.*;
import com.netlearning.framework.em.UserAuthConstants;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.DateUtils;
import com.netlearning.framework.utils.MD5Util;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.mapper.TeacherMapper;
import com.netlearning.user.mapper.UserRoleMapper;
import com.netlearning.user.service.TeacherService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:15
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public CommonResult<List<Teacher>> query(TeacherParam teacherParam) {
        TeacherExample example = new TeacherExample();
        example.setOrderByClause("CREATE_TIME desc");
        TeacherExample.Criteria criteria = example.createCriteria();
        if (teacherParam.getTeacherId() != null){
            criteria.andTeacherIdEqualTo(teacherParam.getTeacherId());
        }
        if (!StringUtils.isEmpty(teacherParam.getTeacherName())){
            criteria.andTeacherNameLike("%"+teacherParam.getTeacherName()+"%");
        }
        if (!StringUtils.isEmpty(teacherParam.getPassword())){
            criteria.andPasswordEqualTo(teacherParam.getPassword());
        }
        if (teacherParam.getDeptId() != null){
            criteria.andDeptIdEqualTo(teacherParam.getDeptId());
        }
        if (!StringUtils.isEmpty(teacherParam.getEmail())){
            criteria.andEmailEqualTo(teacherParam.getEmail());
        }
        if (!StringUtils.isEmpty(teacherParam.getMobile())){
            criteria.andMobileEqualTo(teacherParam.getMobile());
        }
        if (!StringUtils.isEmpty(teacherParam.getStatus())){
            criteria.andStatusEqualTo(teacherParam.getStatus());
        }
        if (!StringUtils.isEmpty(teacherParam.getSex())){
            criteria.andSsexEqualTo(teacherParam.getSex());
        }
        if (!StringUtils.isEmpty(teacherParam.getDescription())){
            criteria.andDescriptionLike("%"+teacherParam.getDescription()+"%");
        }
        if (!StringUtils.isEmpty(teacherParam.getAvatar())){
            criteria.andAvatarEqualTo(teacherParam.getAvatar());
        }
        if(!StringUtils.isEmpty(teacherParam.getStartCreateTime()) && !StringUtils.isEmpty(teacherParam.getEndCreateTime())){
            criteria.andCreateTimeBetween(DateUtils.parseDate(teacherParam.getStartCreateTime()),DateUtils.parseDate(teacherParam.getEndCreateTime()));
        }

        List<Teacher> result = teacherMapper.selectByExample(example);
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<CommonPageResult<Teacher>> page(TeacherParam teacherParam, CommonPageInfo commonPageInfo) {
        TeacherExample example = new TeacherExample();
        example.setOrderByClause("CREATE_TIME desc");
        TeacherExample.Criteria criteria = example.createCriteria();
        if (teacherParam.getTeacherId() != null){
            criteria.andTeacherIdEqualTo(teacherParam.getTeacherId());
        }
        if (!StringUtils.isEmpty(teacherParam.getTeacherName())){
            criteria.andTeacherNameLike("%"+teacherParam.getTeacherName()+"%");
        }
        if (!StringUtils.isEmpty(teacherParam.getPassword())){
            criteria.andPasswordEqualTo(MD5Util.getStringMD5(teacherParam.getPassword()));
        }
        if (teacherParam.getDeptId() != null){
            criteria.andDeptIdEqualTo(teacherParam.getDeptId());
        }
        if (!StringUtils.isEmpty(teacherParam.getEmail())){
            criteria.andEmailEqualTo(teacherParam.getEmail());
        }
        if (!StringUtils.isEmpty(teacherParam.getMobile())){
            criteria.andMobileEqualTo(teacherParam.getMobile());
        }
        if (!StringUtils.isEmpty(teacherParam.getStatus())){
            criteria.andStatusEqualTo(teacherParam.getStatus());
        }
        if (!StringUtils.isEmpty(teacherParam.getSex())){
            criteria.andSsexEqualTo(teacherParam.getSex());
        }
        if (!StringUtils.isEmpty(teacherParam.getDescription())){
            criteria.andDescriptionLike("%"+teacherParam.getDescription()+"%");
        }
        if (!StringUtils.isEmpty(teacherParam.getAvatar())){
            criteria.andAvatarEqualTo(teacherParam.getAvatar());
        }
        if(!StringUtils.isEmpty(teacherParam.getStartCreateTime()) && !StringUtils.isEmpty(teacherParam.getEndCreateTime())){
            criteria.andCreateTimeBetween(DateUtils.parseDate(teacherParam.getStartCreateTime()),DateUtils.parseDate(teacherParam.getEndCreateTime()));
        }

        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<Teacher> result = (Page<Teacher>) teacherMapper.selectByExample(example);
        CommonPageResult<Teacher> pageResult = CommonPageResult.build(result.getResult(),commonPageInfo,result.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public CommonResult<Boolean> add(TeacherAddRequest teacherAddRequest) {
        try {
            if (!UserAuthConstants.UserSexType.userSexTypeList().contains(teacherAddRequest.getSex()) && !StringUtils.isEmpty(teacherAddRequest.getSex())){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE012.code,ExceptionCode.UserAuthCode.CODE012.message);
            }
            Teacher teacher = new Teacher();
            BeanCopyUtils.copyProperties(teacherAddRequest,teacher);
            Long teacherId = sequenceService.nextValue(null);
            teacher.setTeacherId(teacherId);
            teacher.setCreateTime(new Date());
            teacher.setStatus(UserAuthConstants.UserType.UP.getCode());
            teacher.setPassword(MD5Util.getStringMD5(teacher.getPassword()));
            if (StringUtils.isEmpty(teacherAddRequest.getSex())){
                teacher.setSsex(UserAuthConstants.UserSexType.NON.getCode());
            }
            UserRole record = new UserRole();
            if (teacherAddRequest.getRoleId() == null){
                record.setRoleId(UserAuthConstants.SystemDefaultRole.SYSTEM_DEFAULT_TEACHER.getCode());
            }else {
                record.setRoleId(teacherAddRequest.getRoleId());
            }
            record.setUserId(teacherId);
            userRoleMapper.insert(record);
            teacherMapper.insertSelective(teacher);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE002.code,ExceptionCode.UserAuthCode.CODE002.message);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public CommonResult<Boolean> edit(Teacher teacher) {
        try {
            if (!UserAuthConstants.UserType.userTypeList().contains(teacher.getStatus())){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE011.code,ExceptionCode.UserAuthCode.CODE011.message);
            }
            if (!UserAuthConstants.UserSexType.userSexTypeList().contains(teacher.getSsex())){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE012.code,ExceptionCode.UserAuthCode.CODE012.message);
            }
            teacher.setModifyTime(new Date());
            teacher.setPassword(MD5Util.getStringMD5(teacher.getPassword()));
            teacherMapper.updateByPrimaryKeySelective(teacher);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(Long teacherId) {
        try {
            teacherMapper.deleteByPrimaryKey(teacherId);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }
}

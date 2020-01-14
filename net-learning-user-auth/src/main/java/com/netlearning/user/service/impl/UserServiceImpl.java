package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.result.LearningCourseResult;
import com.netlearning.framework.domain.course.result.UserLearningCourseResult;
import com.netlearning.framework.domain.fss.result.FileRecordImagesResult;
import com.netlearning.framework.domain.fss.result.FileRecordResult;
import com.netlearning.framework.domain.userAuth.*;
import com.netlearning.framework.domain.userAuth.param.MyCoursQueryParam;
import com.netlearning.framework.domain.userAuth.result.MyCourseResult;
import com.netlearning.framework.domain.userAuth.result.UserResult;
import com.netlearning.framework.em.UserAuthConstants;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.DateUtils;
import com.netlearning.framework.utils.MD5Util;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.client.FileRecordImagesControllerClientApi;
import com.netlearning.user.client.LearningCourseControllerClientApi;
import com.netlearning.user.mapper.UserMapper;
import com.netlearning.user.mapper.UserRoleMapper;
import com.netlearning.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    @Autowired
    private LearningCourseControllerClientApi learningCourseControllerClientApi;
    @Autowired
    private FileRecordImagesControllerClientApi fileRecordImagesControllerClientApi;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public CommonResult<List<UserResult>> query(UserParam userParam) {
        UserExample example = new UserExample();
        example.setOrderByClause("CREATE_TIME desc");
        UserExample.Criteria criteria = example.createCriteria();
        if (userParam.getUserId() != null){
            criteria.andUserIdEqualTo(userParam.getUserId());
        }
        if (!CollectionUtils.isEmpty(userParam.getUserIds())){
            criteria.andUserIdIn(userParam.getUserIds());
        }
        if (!StringUtils.isEmpty(userParam.getUsername())){
            criteria.andUsernameLike(userParam.getUsername());
        }
        if (!StringUtils.isEmpty(userParam.getPassword())){
            criteria.andPasswordEqualTo(MD5Util.getStringMD5(userParam.getPassword()));
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
        List<UserResult> userResults = new ArrayList<>();
        List<Long> userIds = new ArrayList<>();
        for (User user : result){
            if (!userIds.contains(user.getUserId())){
                userIds.add(user.getUserId());
            }
        }
        Map<Long, FileRecordResult> fileRecordImagesResultMap = new HashMap<>();
        CommonResult<List<FileRecordImagesResult>> fileRecordImagesResult = fileRecordImagesControllerClientApi.query(userIds);
        if (fileRecordImagesResult.isSuccess()){
            List<FileRecordImagesResult> fileRecordImagesResultList = fileRecordImagesResult.getData();
            for (FileRecordImagesResult fileRecordImages : fileRecordImagesResultList){
                if (fileRecordImages.getRecord() != null){
                    if (!fileRecordImagesResultMap.containsKey(fileRecordImages.getRecord().getFromSystemId())){
                        fileRecordImagesResultMap.put(fileRecordImages.getRecord().getFromSystemId(),fileRecordImages.getRecord());
                    }
                }
            }
        }
        for (User user : result){
            UserResult userResult = new UserResult();
            BeanCopyUtils.copyProperties(user,userResult);
            if (fileRecordImagesResultMap.containsKey(user.getUserId())){
                userResult.setUserImageUrl(fileRecordImagesResultMap.get(user.getUserId()).getFileAbsolutePath());
            }else {
                userResult.setUserImageUrl("");
            }
            userResults.add(userResult);
        }
        return CommonResult.success(userResults);
    }

    @Override
    public CommonResult<CommonPageResult<UserResult>> page(UserParam userParam, CommonPageInfo commonPageInfo) {
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
            criteria.andPasswordEqualTo(MD5Util.getStringMD5(userParam.getPassword()));
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
        List<UserResult> userResults = new ArrayList<>();
        List<Long> userIds = new ArrayList<>();
        for (User user : result.getResult()){
            if (!userIds.contains(user.getUserId())){
                userIds.add(user.getUserId());
            }
        }
        Map<Long, FileRecordResult> fileRecordImagesResultMap = new HashMap<>();
        CommonResult<List<FileRecordImagesResult>> fileRecordImagesResult = fileRecordImagesControllerClientApi.query(userIds);
        if (fileRecordImagesResult.isSuccess()){
            List<FileRecordImagesResult> fileRecordImagesResultList = fileRecordImagesResult.getData();
            for (FileRecordImagesResult fileRecordImages : fileRecordImagesResultList){
                if (fileRecordImages.getRecord() != null){
                    if (!fileRecordImagesResultMap.containsKey(fileRecordImages.getRecord().getFromSystemId())){
                        fileRecordImagesResultMap.put(fileRecordImages.getRecord().getFromSystemId(),fileRecordImages.getRecord());
                    }
                }
            }
        }
        for (User user : result.getResult()){
            UserResult userResult = new UserResult();
            BeanCopyUtils.copyProperties(user,userResult);
            if (fileRecordImagesResultMap.containsKey(user.getUserId())){
                userResult.setUserImageUrl(fileRecordImagesResultMap.get(user.getUserId()).getFileAbsolutePath());
            }else {
                userResult.setUserImageUrl("");
            }
            userResults.add(userResult);
        }
        CommonPageResult<UserResult> pageResult = CommonPageResult.build(userResults,commonPageInfo,result.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    @Transactional
    public CommonResult<Boolean> add(UserAddRequest user) {
        try {

            if (!UserAuthConstants.UserSexType.userSexTypeList().contains(user.getSsex()) && !StringUtils.isEmpty(user.getSsex())){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE012.code,ExceptionCode.UserAuthCode.CODE012.message);
            }
            //查询用户手机号-邮箱-用户名是否重复
            if (!StringUtils.isEmpty(user.getUsername())){
                UserExample example = new UserExample();
                example.createCriteria().andUsernameEqualTo(user.getUsername());
                List<User> userList = userMapper.selectByExample(example);
                if (!CollectionUtils.isEmpty(userList)){
                    return CommonResult.fail(ExceptionCode.UserAuthCode.CODE018.code,ExceptionCode.UserAuthCode.CODE018.message);
                }
            }
            if (StringUtils.isEmpty(user.getMobile())){
                UserExample example = new UserExample();
                example.createCriteria().andMobileEqualTo(user.getMobile());
                List<User> userList = userMapper.selectByExample(example);
                if (!CollectionUtils.isEmpty(userList)){
                    return CommonResult.fail(ExceptionCode.UserAuthCode.CODE020.code,ExceptionCode.UserAuthCode.CODE020.message);
                }
            }
            if (StringUtils.isEmpty(user.getEmail())){
                UserExample example = new UserExample();
                example.createCriteria().andEmailEqualTo(user.getEmail());
                List<User> userList = userMapper.selectByExample(example);
                if (!CollectionUtils.isEmpty(userList)){
                    return CommonResult.fail(ExceptionCode.UserAuthCode.CODE019.code,ExceptionCode.UserAuthCode.CODE019.message);
                }
            }

            User record = new User();
            BeanCopyUtils.copyProperties(user,record);
            Long userId = sequenceService.nextValue(null);
            record.setUserId(userId);
            record.setStatus(UserAuthConstants.UserType.UP.getCode());
            record.setCreateTime(new Date());
            if (StringUtils.isEmpty(user.getSsex())){
                record.setSsex(UserAuthConstants.UserSexType.NON.getCode());
            }
            record.setPassword(MD5Util.getStringMD5(user.getPassword()));
            UserRole userRole = new UserRole();
            if (user.getRoleId() == null){
                userRole.setRoleId(UserAuthConstants.SystemDefaultRole.SYSTEM_DEFAULT_STUDENT.getCode());
            }else {
                userRole.setRoleId(user.getRoleId());
            }
            userRole.setUserId(userId);
            userRoleMapper.insertSelective(userRole);
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

    @Override
    public CommonResult<MyCourseResult> queryMyCourse(MyCoursQueryParam param) {

        CommonResult<UserLearningCourseResult> userLearningCourseResult = learningCourseControllerClientApi.query(param.getUserId());
        if (userLearningCourseResult.isSuccess()){
            List<LearningCourseResult> userLearningCourseList = userLearningCourseResult.getData().getLearningCourseResults();
        }

        return null;
    }
}

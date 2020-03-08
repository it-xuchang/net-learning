package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.domain.fss.result.FileRecordImagesResult;
import com.netlearning.framework.domain.userAuth.param.*;
import com.netlearning.framework.domain.userAuth.result.RoleResult;
import com.netlearning.framework.domain.userAuth.result.TeacherResult;
import com.netlearning.framework.em.FileConstants;
import com.netlearning.user.client.FileRecordControllerClientApi;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.result.CourseBaseResult;
import com.netlearning.framework.domain.course.result.CourseRecommendationResult;
import com.netlearning.framework.domain.fss.result.FileRecordResult;
import com.netlearning.framework.domain.userAuth.*;
import com.netlearning.framework.domain.userAuth.result.TeacherRecommendationResult;
import com.netlearning.framework.em.UserAuthConstants;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.DateUtils;
import com.netlearning.framework.utils.MD5Util;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.client.CourseBaseClientApi;
import com.netlearning.user.client.FileRecordImagesControllerClientApi;
import com.netlearning.user.mapper.RoleMapper;
import com.netlearning.user.mapper.TeacherMapper;
import com.netlearning.user.mapper.UserRoleMapper;
import com.netlearning.user.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    @Autowired
    private CourseBaseClientApi courseBaseClientApi;
    @Autowired
    private FileRecordControllerClientApi fileRecordControllerClientApi;
    @Autowired
    private FileRecordImagesControllerClientApi fileRecordImagesControllerClientApi;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public CommonResult<List<TeacherResult>> query(TeacherParam teacherParam) {
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

        List<Teacher> result = teacherMapper.selectByExample(example);
        List<TeacherResult> teacherResults = new ArrayList<>();
        List<Long> teacherIds = new ArrayList<>();

        for (Teacher teacher : result){
            if (!teacherIds.contains(teacher.getTeacherId())){
                teacherIds.add(teacher.getTeacherId());
            }
        }
        //教师id --文件资源信息
        Map<Long,FileRecordResult> fileRecordResultMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(teacherIds)){
            //调用文件系统是微服务
            CommonResult<List<FileRecordImagesResult>> fileRecordImagesResult =  fileRecordImagesControllerClientApi.query(teacherIds, FileConstants.IsAvatar.AVATAR.getCode());
            List<FileRecordImagesResult> fileRecordResultList = fileRecordImagesResult.getData();
            for (FileRecordImagesResult fileRecord : fileRecordResultList){
                if (!fileRecordResultMap.containsKey(fileRecord.getRecord().getFromSystemId())){
                    fileRecordResultMap.put(fileRecord.getRecord().getFromSystemId(),fileRecord.getRecord());
                }
            }
        }

        Map<Long, RoleResult> teacherRoleMap = new HashMap<>();
        UserRoleExample userRoleExample = new UserRoleExample();
        if (!CollectionUtils.isEmpty(teacherIds)){
            userRoleExample.createCriteria().andUserIdIn(teacherIds);
            List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
            //roleId role
            Map<Long, Role> roleMap = new HashMap<>();
            List<Role> roleList = roleMapper.selectByExample(new RoleExample());
            for (Role role : roleList){
                if (!roleMap.containsKey(role.getRoleId())){
                    roleMap.put(role.getRoleId(),role);
                }
            }
            for (UserRole userRole : userRoleList){
                if(!teacherRoleMap.containsKey(userRole.getUserId())){
                    if (roleMap.containsKey(userRole.getRoleId())){
                        RoleResult roleResult = new RoleResult();
                        BeanCopyUtils.copyProperties(roleMap.get(userRole.getRoleId()),roleResult);
                        teacherRoleMap.put(userRole.getUserId(),roleResult);
                    }
                }
            }
        }
        for (Teacher teacher : result){
            TeacherResult teacherResult = new TeacherResult();
            BeanCopyUtils.copyProperties(teacher,teacherResult);
            if (fileRecordResultMap.containsKey(teacher.getTeacherId())){
                teacherResult.setTeacherImageUrl(fileRecordResultMap.get(teacher.getTeacherId()).getFileAbsolutePath());
            }else {
                teacherResult.setTeacherImageUrl("");
            }
            if(teacherRoleMap.containsKey(teacher.getTeacherId())){
                teacherResult.setRoleResult(teacherRoleMap.get(teacher.getTeacherId()));
            }
            teacherResults.add(teacherResult);
        }

        return CommonResult.success(teacherResults);
    }

    @Override
    public CommonResult<CommonPageResult<TeacherResult>> page(TeacherParam teacherParam, CommonPageInfo commonPageInfo) {
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

        List<TeacherResult> teacherResults = new ArrayList<>();
        List<Long> teacherIds = new ArrayList<>();

        for (Teacher teacher : result.getResult()){
            if (!teacherIds.contains(teacher.getTeacherId())){
                teacherIds.add(teacher.getTeacherId());
            }
        }
        //教师id --文件资源信息
        Map<Long,FileRecordResult> fileRecordResultMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(teacherIds)){
            //调用文件系统是微服务
            CommonResult<List<FileRecordImagesResult>> fileRecordImagesResult =  fileRecordImagesControllerClientApi.query(teacherIds,FileConstants.IsAvatar.AVATAR.getCode());
            List<FileRecordImagesResult> fileRecordResultList = fileRecordImagesResult.getData();
            for (FileRecordImagesResult fileRecord : fileRecordResultList){
                if (!fileRecordResultMap.containsKey(fileRecord.getRecord().getFromSystemId())){
                    fileRecordResultMap.put(fileRecord.getRecord().getFromSystemId(),fileRecord.getRecord());
                }
            }
        }

        Map<Long, RoleResult> teacherRoleMap = new HashMap<>();
        UserRoleExample userRoleExample = new UserRoleExample();
        if (!CollectionUtils.isEmpty(teacherIds)){
            userRoleExample.createCriteria().andUserIdIn(teacherIds);
            List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
            //roleId role
            Map<Long, Role> roleMap = new HashMap<>();
            List<Role> roleList = roleMapper.selectByExample(new RoleExample());
            for (Role role : roleList){
                if (!roleMap.containsKey(role.getRoleId())){
                    roleMap.put(role.getRoleId(),role);
                }
            }
            for (UserRole userRole : userRoleList){
                if(!teacherRoleMap.containsKey(userRole.getUserId())){
                    if (roleMap.containsKey(userRole.getRoleId())){
                        RoleResult roleResult = new RoleResult();
                        BeanCopyUtils.copyProperties(roleMap.get(userRole.getRoleId()),roleResult);
                        teacherRoleMap.put(userRole.getUserId(),roleResult);
                    }
                }
            }
        }
        for (Teacher teacher : result.getResult()){
            TeacherResult teacherResult = new TeacherResult();
            BeanCopyUtils.copyProperties(teacher,teacherResult);
            if (fileRecordResultMap.containsKey(teacher.getTeacherId())){
                teacherResult.setTeacherImageUrl(fileRecordResultMap.get(teacher.getTeacherId()).getFileAbsolutePath());
            }else {
                teacherResult.setTeacherImageUrl("");
            }
            if(teacherRoleMap.containsKey(teacher.getTeacherId())){
                teacherResult.setRoleResult(teacherRoleMap.get(teacher.getTeacherId()));
            }
            teacherResults.add(teacherResult);
        }

        CommonPageResult<TeacherResult> pageResult = CommonPageResult.build(teacherResults,commonPageInfo,result.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public CommonResult<Boolean> add(TeacherAddRequest teacherAddRequest) {
        try {
            if (!UserAuthConstants.UserSexType.userSexTypeList().contains(teacherAddRequest.getSex()) && !StringUtils.isEmpty(teacherAddRequest.getSex())){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE012.code,ExceptionCode.UserAuthCode.CODE012.message);
            }
            //教师名称-教师手机号-教师邮箱
            if (!StringUtils.isEmpty(teacherAddRequest.getTeacherName())){
                TeacherExample example = new TeacherExample();
                example.createCriteria().andTeacherNameEqualTo(teacherAddRequest.getTeacherName());
                List<Teacher> teacherList = teacherMapper.selectByExample(example);
                if (!CollectionUtils.isEmpty(teacherList)){
                    return CommonResult.fail(ExceptionCode.UserAuthCode.CODE018.code,ExceptionCode.UserAuthCode.CODE018.message);
                }
            }
            if (!StringUtils.isEmpty(teacherAddRequest.getMobile())){
                TeacherExample example = new TeacherExample();
                example.createCriteria().andMobileEqualTo(teacherAddRequest.getMobile());
                List<Teacher> teacherList = teacherMapper.selectByExample(example);
                if (!CollectionUtils.isEmpty(teacherList)){
                    return CommonResult.fail(ExceptionCode.UserAuthCode.CODE020.code,ExceptionCode.UserAuthCode.CODE020.message);
                }
            }
            if (!StringUtils.isEmpty(teacherAddRequest.getEmail())){
                TeacherExample example = new TeacherExample();
                example.createCriteria().andEmailEqualTo(teacherAddRequest.getEmail());
                List<Teacher> teacherList = teacherMapper.selectByExample(example);
                if (!CollectionUtils.isEmpty(teacherList)){
                    return CommonResult.fail(ExceptionCode.UserAuthCode.CODE019.code,ExceptionCode.UserAuthCode.CODE019.message);
                }
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
    public CommonResult<Boolean> edit(TeacherEditParam teacher) {
        try {
            if (!StringUtils.isEmpty(teacher.getStatus())){
                if (!UserAuthConstants.UserType.userTypeList().contains(teacher.getStatus())){
                    return CommonResult.fail(ExceptionCode.UserAuthCode.CODE011.code,ExceptionCode.UserAuthCode.CODE011.message);
                }
            }
            if (!UserAuthConstants.UserSexType.userSexTypeList().contains(teacher.getSex())){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE012.code,ExceptionCode.UserAuthCode.CODE012.message);
            }
            Teacher record = new Teacher();
            BeanCopyUtils.copyProperties(teacher,record);
            record.setModifyTime(new Date());
            if (StringUtils.isEmpty(teacher.getSex())){
                record.setSsex(UserAuthConstants.UserSexType.NON.getCode());
            }else {
                record.setSsex(teacher.getSex());
            }
            teacherMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(TeacherDeleteParam param) {
        try {
            if (param.getTeacherId() == null && CollectionUtils.isEmpty(param.getTeacherIds()) ){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
            }
            TeacherExample example = new TeacherExample();
            TeacherExample.Criteria criteria = example.createCriteria();
            if (param.getTeacherId() != null){
                criteria.andTeacherIdEqualTo(param.getTeacherId());
            }
            if (!CollectionUtils.isEmpty(param.getTeacherIds())){
                criteria.andTeacherIdIn(param.getTeacherIds());
            }
            teacherMapper.deleteByExample(example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<List<TeacherRecommendationResult>> queryTeacherRecommendation(Long size) {

        CommonResult<List<CourseRecommendationResult>> courseRecommendationResult = courseBaseClientApi.queryCourseRecommendation(size);
        List<Long> teacherIds = new ArrayList<>();
        List<Long> couresIds = new ArrayList<>();
        //课程id 课程用户学习量
        Map<Long,Integer> courseRecommendationMap = new HashMap<>();
        //教师id 教师课程信息
        Map<Long,List<CourseBaseResult>> teacherCourseMap = new HashMap<>();
        if (courseRecommendationResult.isSuccess()){
            List<CourseRecommendationResult> courseRecommendationResultList = courseRecommendationResult.getData();
            for (CourseRecommendationResult recommendationResult : courseRecommendationResultList){
                    if (!couresIds.contains(recommendationResult.getCourseId())){
                        couresIds.add(recommendationResult.getCourseId());
                    }
                    if (!courseRecommendationMap.containsKey(recommendationResult.getCourseId())){
                        courseRecommendationMap.put(recommendationResult.getCourseId(),recommendationResult.getLearningUser());
                    }
            }
            if (!CollectionUtils.isEmpty(couresIds)){
                CommonResult<List<CourseBaseResult>> couresResult =  courseBaseClientApi.queryByCouresIds(couresIds);
                if (couresResult.isSuccess()){

                    List<CourseBaseResult> courseBaseResultList = couresResult.getData();
                    if (!CollectionUtils.isEmpty(courseBaseResultList)){
                        for (CourseBaseResult courseBaseResult : courseBaseResultList){
                            if (!teacherIds.contains(courseBaseResult.getTeacherId())){
                                teacherIds.add(courseBaseResult.getTeacherId());
                            }

                            if (teacherCourseMap.containsKey(courseBaseResult.getTeacherId())){
                                teacherCourseMap.get(courseBaseResult.getTeacherId()).add(courseBaseResult);
                            }else {
                                List<CourseBaseResult> list = new ArrayList<>();
                                list.add(courseBaseResult);
                                teacherCourseMap.put(courseBaseResult.getTeacherId(),list);
                            }
                        }
                    }
                }
            }
        }
        List<TeacherRecommendationResult> teacherRecommendationResults = new ArrayList<>();
        //教师id 教师信息
        Map<Long,Teacher> teacherMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(teacherIds)){
            TeacherExample example = new TeacherExample();
            example.createCriteria().andTeacherIdIn(teacherIds);
            List<Teacher> teacherList = teacherMapper.selectByExample(example);
            for (Teacher teacher : teacherList){
                if (!teacherMap.containsKey(teacher.getTeacherId())){
                    teacherMap.put(teacher.getTeacherId(),teacher);
                }
            }
        }
        //教师id --文件资源信息
        Map<Long,FileRecordResult> fileRecordResultMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(teacherIds)){
            //调用文件系统是微服务
//            CommonResult<List<FileRecordResult>> fileRecordResult = fileRecordControllerClientApi.queryByFromSystemIds(teacherIds);
            CommonResult<List<FileRecordImagesResult>> fileRecordImagesResult =  fileRecordImagesControllerClientApi.query(teacherIds);
            List<FileRecordImagesResult> fileRecordResultList = fileRecordImagesResult.getData();
            for (FileRecordImagesResult fileRecord : fileRecordResultList){
                if (!fileRecordResultMap.containsKey(fileRecord.getRecord().getFromSystemId())){
                    fileRecordResultMap.put(fileRecord.getRecord().getFromSystemId(),fileRecord.getRecord());
                }
            }
        }


        for (Map.Entry<Long,List<CourseBaseResult>> entry : teacherCourseMap.entrySet()){
            Long key = entry.getKey();
            List<CourseBaseResult> value = entry.getValue();
            for (CourseBaseResult courseBase : value){
                TeacherRecommendationResult teacherRecommendationResult = new TeacherRecommendationResult();
                if (courseRecommendationMap.containsKey(courseBase.getCourseId())){
                    teacherRecommendationResult.setLearningUser(courseRecommendationMap.get(courseBase.getCourseId()));
                }else {
                    teacherRecommendationResult.setLearningUser(0);
                }

                if (teacherMap.containsKey(key)){
                    Teacher teacher = teacherMap.get(key);
                    teacherRecommendationResult.setTeacherId(key);
                    teacherRecommendationResult.setTeacherName(teacher.getTeacherName());
                    teacherRecommendationResult.setAvatar(teacher.getAvatar());
                    teacherRecommendationResult.setCourseName(courseBase.getCourseName());

                    if (fileRecordResultMap.containsKey(key)){
                        teacherRecommendationResult.setTeacherImageUrl(fileRecordResultMap.get(key).getFileAbsolutePath());
                    }else {
                        teacherRecommendationResult.setTeacherImageUrl("");
                    }
                    teacherRecommendationResults.add(teacherRecommendationResult);
                }

            }

        }

        return CommonResult.success(teacherRecommendationResults);
    }

    @Transactional
    @Override
    public CommonResult changePassword(UserChangePasswordParam param) {
        //输入密码是否一致
        if (StringUtils.equals(param.getNewPassword(),param.getOldPassword())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE025.code,ExceptionCode.UserAuthCode.CODE025.message);
        }
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria =example.createCriteria();
        if (!StringUtils.isEmpty(param.getMobile())){
            criteria.andMobileEqualTo(param.getMobile());
        }
        if (!StringUtils.isEmpty(param.getEmail())){
            criteria.andEmailEqualTo(param.getEmail());
        }
        if (!StringUtils.isEmpty(param.getOldPassword())){
            criteria.andPasswordEqualTo(MD5Util.getStringMD5(param.getOldPassword()));
        }
        List<Teacher> teacherList = teacherMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(teacherList)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE022.code,ExceptionCode.UserAuthCode.CODE022.message);
        }
        Teacher teacher = teacherList.get(0);
        if (StringUtils.equals(teacher.getStatus(),UserAuthConstants.UserType.DOWN.getCode())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE023.code,ExceptionCode.UserAuthCode.CODE023.message);
        }
        //新旧密码是否一致
        if (StringUtils.equals(teacher.getPassword(),MD5Util.getStringMD5(param.getNewPassword()))){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE024.code,ExceptionCode.UserAuthCode.CODE024.message);
        }
        Teacher record = new Teacher();
        record.setPassword(MD5Util.getStringMD5(param.getNewPassword()));
        record.setTeacherId(teacher.getTeacherId());
        teacherMapper.updateByPrimaryKeySelective(record);
        return CommonResult.success(true);
    }

    @Override
    @Transactional
    public CommonResult changeStatus(TeacherChangeStatusParam param) {
        Teacher record = new Teacher();
        record.setTeacherId(param.getTeacherId());
        record.setStatus(param.getStatus());
        teacherMapper.updateByPrimaryKeySelective(record);
        return CommonResult.success(true);
    }
}

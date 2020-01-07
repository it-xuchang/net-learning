package com.netlearning.course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.course.client.UserControllerClientApi;
import com.netlearning.course.mapper.CourseAssessmentMapper;
import com.netlearning.course.service.CourseAssessmentService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.CourseAssessment;
import com.netlearning.framework.domain.course.CourseAssessmentExample;
import com.netlearning.framework.domain.course.param.CourseAssessmentAddParam;
import com.netlearning.framework.domain.course.param.CourseAssessmentEditParam;
import com.netlearning.framework.domain.course.param.CourseAssessmentQueryParam;
import com.netlearning.framework.domain.course.result.CourseAssessmentResult;
import com.netlearning.framework.domain.userAuth.User;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/7 13:16
 */
@Service
public class CourseAssessmentServiceImpl implements CourseAssessmentService {
    @Autowired
    private CourseAssessmentMapper courseAssessmentMapper;
    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private UserControllerClientApi userControllerClientApi;

    @Override
    public CommonResult<CommonPageResult<CourseAssessmentResult>> page(CourseAssessmentQueryParam param, CommonPageInfo commonPageInfo) {

        CourseAssessmentExample example = new CourseAssessmentExample();
        if (param.getCourseId() != null){
            example.setOrderByClause("create_time DESC");
            example.createCriteria().andCourseIdEqualTo(param.getCourseId());
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<CourseAssessment> courseAssessmentPage = (Page<CourseAssessment>) courseAssessmentMapper.selectByExample(example);
        List<Long> userIds = new ArrayList<>();
        for (CourseAssessment courseAssessment : courseAssessmentPage.getResult()){
            if (!userIds.contains(courseAssessment.getUserId())){
                userIds.add(courseAssessment.getUserId());
            }
        }
        Map<Long,User> userMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(userIds)){
            CommonResult<List<User>> userResult = userControllerClientApi.queryByUserIds(userIds);
            if (userResult.isSuccess()){
                List<User> users = userResult.getData();
                for (User user : users){
                    if (!userMap.containsKey(user.getUserId())){
                        userMap.put(user.getUserId(),user);
                    }
                }
            }
        }
        List<CourseAssessmentResult> courseAssessmentResults = new ArrayList<>();
        for (CourseAssessment courseAssessment : courseAssessmentPage.getResult()){
            CourseAssessmentResult assessmentResult = new CourseAssessmentResult();
            BeanCopyUtils.copyProperties(courseAssessment,assessmentResult);
            if (userMap.containsKey(courseAssessment.getUserId())){
                assessmentResult.setUser(userMap.get(courseAssessment.getUserId()));
            }
            courseAssessmentResults.add(assessmentResult);
        }
        CommonPageResult<CourseAssessmentResult> pageResult = CommonPageResult.build(courseAssessmentResults,commonPageInfo,courseAssessmentPage.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(CourseAssessmentAddParam param) {
        CourseAssessment record = new CourseAssessment();
        BeanCopyUtils.copyProperties(param,record);
        record.setCourseAssessmentId(sequenceService.nextValue(null));
        record.setCreateTime(new Date());
        courseAssessmentMapper.insertSelective(record);
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> edit(CourseAssessmentEditParam param) {
        CourseAssessment record = new CourseAssessment();
        BeanCopyUtils.copyProperties(param,record);
        record.setUpdateTime(new Date());
        courseAssessmentMapper.updateByPrimaryKeySelective(record);

        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> delete(Long courseAssessmentId) {
        courseAssessmentMapper.deleteByPrimaryKey(courseAssessmentId);
        return CommonResult.success(true);
    }
}

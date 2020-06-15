package com.netlearning.course.service.impl;

import com.github.pagehelper.Page;
import com.netlearning.course.client.FileRecordImagesControllerClientApi;
import com.netlearning.course.client.FileRecordResourcesControllerClientApi;
import com.netlearning.course.mapper.CourseBaseMapper;
import com.netlearning.course.mapper.LearningCourseMapper;
import com.netlearning.course.mapper.LearningTeachplanMapper;
import com.netlearning.course.mapper.TeachPlanMapper;
import com.netlearning.course.service.LearningCourseService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.*;
import com.netlearning.framework.domain.course.param.LearningCourseAddParam;
import com.netlearning.framework.domain.course.param.LearningCourseEditParam;
import com.netlearning.framework.domain.course.param.LearningCourseQueryParam;
import com.netlearning.framework.domain.course.param.PersonCourseParam;
import com.netlearning.framework.domain.course.result.*;
import com.netlearning.framework.domain.fss.result.FileRecordImagesResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.DateUtils;
import com.netlearning.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 22:26
 */
@Service
public class LearningCourseServiceImpl implements LearningCourseService {
    @Autowired
    private LearningCourseMapper learningCourseMapper;
    @Autowired
    private CourseBaseMapper courseBaseMapper;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private LearningTeachplanMapper learningTeachplanMapper;
    @Autowired
    private TeachPlanMapper teachPlanMapper;
    @Autowired
    private FileRecordImagesControllerClientApi fileRecordImagesControllerClientApi;
    @Autowired
    private FileRecordResourcesControllerClientApi fileRecordResourcesControllerClientApi;
    @Override
    public CommonResult<UserLearningCourseResult> query(LearningCourseQueryParam param) {
        List<Long> courseIds = new ArrayList<>();
        if (param.getTeacherId() != null){
            CourseBaseExample courseBaseExample = new CourseBaseExample();
            courseBaseExample.createCriteria().andTeacherIdEqualTo(param.getTeacherId());
            List<CourseBase> courseBaseList = courseBaseMapper.selectByExample(courseBaseExample);
            for (CourseBase courseBase : courseBaseList){
                if (!courseIds.contains(courseBase.getCourseId())){
                    courseIds.add(courseBase.getCourseId());
                }
            }
        }
        if (param.getCourseId() != null && !courseIds.contains(param.getCourseId())){
            courseIds.add(param.getCourseId());
        }

        LearningCourseExample learningCourseExample = new LearningCourseExample();
        LearningCourseExample.Criteria learningCourseExampleCriteria = learningCourseExample.createCriteria();
        if (!CollectionUtils.isEmpty(courseIds)){
            learningCourseExampleCriteria.andCourseIdIn(courseIds);
        }
        if (param.getUserId() != null){
            learningCourseExampleCriteria.andUserIdEqualTo(param.getUserId());
        }
        if (param.getLearningId() != null){
            learningCourseExampleCriteria.andLearningIdEqualTo(param.getLearningId());
        }
        if (!StringUtils.isEmpty(param.getCreateTime()) && !StringUtils.isEmpty(param.getEndTime())){
            learningCourseExampleCriteria.andCreateTimeBetween(DateUtils.parseDate(param.getCreateTime()),
                    DateUtils.parseDate(param.getEndTime()));
        }

        List<LearningCourse>  learningCourseList = learningCourseMapper.selectByExample(learningCourseExample);
        if (!CollectionUtils.isEmpty(learningCourseList)
                && param.getTeacherId() == null
                && param.getCourseId() == null){
            for (LearningCourse learningCourse  : learningCourseList){
                if (!courseIds.contains(learningCourse.getCourseId())){
                    courseIds.add(learningCourse.getCourseId());
                }
            }

        }
        Map<Long, CourseBaseResult> courseBaseMap = new HashMap<>();
        CourseBaseExample courseBaseExample = new CourseBaseExample();
        if (!CollectionUtils.isEmpty(courseIds)){
            courseBaseExample.createCriteria().andCourseIdIn(courseIds);
        }
        List<CourseBase> courseBaseList = courseBaseMapper.selectByExample(courseBaseExample);
        for (CourseBase courseBase : courseBaseList){
            CourseBaseResult baseResult = new CourseBaseResult();
            BeanCopyUtils.copyProperties(courseBase,baseResult);
            courseBaseMap.put(courseBase.getCourseId(),baseResult);
        }

        List<LearningCourseResult> learningCourseResults = BeanCopyUtils.copy(learningCourseList,LearningCourseResult.class);

        //userId -- List<LearningCourseResult>
        Map<Long,List<LearningCourseResult>> learningCourseMap = new HashMap<>();
        for (LearningCourseResult learningCourseResult : learningCourseResults){
            if (courseBaseMap.containsKey(learningCourseResult.getCourseId())){
                learningCourseResult.setCourseBaseResult(courseBaseMap.get(learningCourseResult.getCourseId()));
            }

            if (learningCourseMap.containsKey(learningCourseResult.getUserId())){
                learningCourseMap.get(learningCourseResult.getUserId()).add(learningCourseResult);
            }else {
                List<LearningCourseResult>  list = new ArrayList<>();
                list.add(learningCourseResult);
                learningCourseMap.put(learningCourseResult.getUserId(),list);
            }
        }
        UserLearningCourseResult userLearningCourseResult = new UserLearningCourseResult();
        for (Map.Entry<Long,List<LearningCourseResult>> entry : learningCourseMap.entrySet()){
            userLearningCourseResult.setUserId(entry.getKey());
            userLearningCourseResult.setLearningCourseResults(entry.getValue());
        }
        return CommonResult.success(userLearningCourseResult);
    }

    @Override
    public CommonResult<CommonPageResult<UserLearningCourseResult>> page(LearningCourseQueryParam param, CommonPageInfo commonPageInfo) {

        List<Long> courseIds = new ArrayList<>();
        if (param.getTeacherId() != null){
            CourseBaseExample courseBaseExample = new CourseBaseExample();
            courseBaseExample.createCriteria().andTeacherIdEqualTo(param.getTeacherId());
            List<CourseBase> courseBaseList = courseBaseMapper.selectByExample(courseBaseExample);
            for (CourseBase courseBase : courseBaseList){
                if (!courseIds.contains(courseBase.getCourseId())){
                    courseIds.add(courseBase.getCourseId());
                }
            }
        }
        if (param.getCourseId() != null && !courseIds.contains(param.getCourseId())){
            courseIds.add(param.getCourseId());
        }

        LearningCourseExample learningCourseExample = new LearningCourseExample();
        LearningCourseExample.Criteria learningCourseExampleCriteria = learningCourseExample.createCriteria();
        if (!CollectionUtils.isEmpty(courseIds)){
            learningCourseExampleCriteria.andCourseIdIn(courseIds);
        }
        if (param.getUserId() != null){
            learningCourseExampleCriteria.andUserIdEqualTo(param.getUserId());
        }
        if (param.getLearningId() != null){
            learningCourseExampleCriteria.andLearningIdEqualTo(param.getLearningId());
        }
        if (!StringUtils.isEmpty(param.getCreateTime()) && !StringUtils.isEmpty(param.getEndTime())){
            learningCourseExampleCriteria.andCreateTimeBetween(DateUtils.parseDate(param.getCreateTime()),
                    DateUtils.parseDate(param.getEndTime()));
        }

        List<LearningCourse>  learningCourseList = learningCourseMapper.selectByExample(learningCourseExample);
        if (!CollectionUtils.isEmpty(learningCourseList)
                && param.getTeacherId() == null
                && param.getCourseId() == null){
            for (LearningCourse learningCourse  : learningCourseList){
                if (!courseIds.contains(learningCourse.getCourseId())){
                    courseIds.add(learningCourse.getCourseId());
                }
            }

        }
        Map<Long, CourseBaseResult> courseBaseMap = new HashMap<>();
        CourseBaseExample courseBaseExample = new CourseBaseExample();
        if (!CollectionUtils.isEmpty(courseIds)){
            courseBaseExample.createCriteria().andCourseIdIn(courseIds);
        }
        List<CourseBase> courseBaseList = courseBaseMapper.selectByExample(courseBaseExample);
        for (CourseBase courseBase : courseBaseList){
            CourseBaseResult baseResult = new CourseBaseResult();
            BeanCopyUtils.copyProperties(courseBase,baseResult);
            courseBaseMap.put(courseBase.getCourseId(),baseResult);
        }

        List<LearningCourseResult> learningCourseResults = BeanCopyUtils.copy(learningCourseList,LearningCourseResult.class);

        //userId -- List<LearningCourseResult>
        Map<Long,List<LearningCourseResult>> learningCourseMap = new HashMap<>();
        for (LearningCourseResult learningCourseResult : learningCourseResults){
            if (courseBaseMap.containsKey(learningCourseResult.getCourseId())){
                learningCourseResult.setCourseBaseResult(courseBaseMap.get(learningCourseResult.getCourseId()));
            }

            if (learningCourseMap.containsKey(learningCourseResult.getUserId())){
                learningCourseMap.get(learningCourseResult.getUserId()).add(learningCourseResult);
            }else {
                List<LearningCourseResult>  list = new ArrayList<>();
                list.add(learningCourseResult);
                learningCourseMap.put(learningCourseResult.getUserId(),list);
            }
        }
        List<UserLearningCourseResult> results = new ArrayList<>();
        for (Map.Entry<Long,List<LearningCourseResult>> entry : learningCourseMap.entrySet()){
            UserLearningCourseResult userLearningCourseResult = new UserLearningCourseResult();
            userLearningCourseResult.setUserId(entry.getKey());
            userLearningCourseResult.setLearningCourseResults(entry.getValue());
            results.add(userLearningCourseResult);
        }
        int pageNo=(commonPageInfo.getPageNum()-1)*commonPageInfo.getPageSize();   //每页的起始索引
        int pageSize=commonPageInfo.getPageSize(); // 每页记录数
        long total = results.size();
        if (pageNo+pageSize > total) {
            results = results.subList(pageNo, (int) total);
        }else {
            results = results.subList(pageNo,pageNo+pageSize);
        }
        CommonPageResult<UserLearningCourseResult> pageResult = CommonPageResult.build(results,commonPageInfo,total);
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(LearningCourseAddParam request) {
        if (request.getCourseId() == null ){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE012.code,ExceptionCode.CourseCode.CODE012.message);
        }
        if (request.getUserId() == null){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE013.code,ExceptionCode.CourseCode.CODE013.message);
        }

        LearningCourse record = new LearningCourse();
        BeanCopyUtils.copyProperties(request,record);
        record.setLearningId(sequenceService.nextValue(null));
        if (StringUtils.isEmpty(request.getCreateTime())){
            record.setCreateTime(new Date());
        }
        if (!StringUtils.isEmpty(request.getEndTime())){
            record.setEndTime(DateUtils.parseDatetime(request.getEndTime()));
        }
        LearningCourseExample example = new LearningCourseExample();
        LearningCourseExample.Criteria criteria =example.createCriteria();
        if (request.getCourseId() != null ){
            criteria.andCourseIdEqualTo(request.getCourseId());
        }
        if (request.getUserId() != null){
            criteria.andUserIdEqualTo(request.getUserId());
        }
        List<LearningCourse> learningCourseList = learningCourseMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(learningCourseList)){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE011.code,ExceptionCode.CourseCode.CODE011.message);
        }
        try {
            learningCourseMapper.insertSelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE002.code,ExceptionCode.CourseCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(LearningCourseEditParam request) {
        try {
            LearningCourse record = new LearningCourse();
            BeanCopyUtils.copyProperties(request,record);
            if (!StringUtils.isEmpty(request.getCreateTime())){
                record.setCreateTime(DateUtils.parseDatetime(request.getCreateTime()));
            }
            if (!StringUtils.isEmpty(request.getEndTime())){
                record.setEndTime(DateUtils.parseDatetime(request.getEndTime()));
            }
            learningCourseMapper.updateByPrimaryKeySelective(record);

            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE003.code,ExceptionCode.CourseCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(List<Long> ids) {
        try {
            LearningCourseExample example = new LearningCourseExample();
            if (!CollectionUtils.isEmpty(ids)){
                example.createCriteria().andLearningIdIn(ids);
            }
            learningCourseMapper.deleteByExample(example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE003.code,ExceptionCode.CourseCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<CommonPageResult<PersonCourseResult>> queryPersonCourse(PersonCourseParam param, CommonPageInfo commonPageInfo) {

        LearningCourseExample example = new LearningCourseExample();
        LearningCourseExample.Criteria criteria = example.createCriteria();
        if (param.getUserId() != null){
            criteria.andUserIdEqualTo(param.getUserId());
        }
        List<LearningCourse> learningCourseList =  learningCourseMapper.selectByExample(example);
        List<Long> courseIds = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        for (LearningCourse learningCourse : learningCourseList){
            if (!courseIds.contains(learningCourse.getCourseId())){
                courseIds.add(learningCourse.getCourseId());
            }
            ids.add(String.valueOf(learningCourse.getCourseId()));
        }
        if (CollectionUtils.isEmpty(courseIds)){
            CommonResult.success(CommonPageResult.build(new ArrayList<>(),commonPageInfo,0));
        }
        //课程id  课程的url
        Map<Long,String> imagesUrlMap = new HashMap<>();
        Map<Long,CourseBaseResult> courseBaseResultMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(courseIds)){
            CourseBaseExample courseBaseExample = new CourseBaseExample();
            courseBaseExample.createCriteria().andCourseIdIn(courseIds);
            List<CourseBase> courseBaseList = courseBaseMapper.selectByExampleWithBLOBs(courseBaseExample);

            CommonResult<List<FileRecordImagesResult>> fileResordImagesResult = fileRecordImagesControllerClientApi.query(courseIds);
            if (fileResordImagesResult.isSuccess()){
                if (!CollectionUtils.isEmpty(fileResordImagesResult.getData())){
                    for (FileRecordImagesResult fileRecordImages : fileResordImagesResult.getData()){
                        imagesUrlMap.put(fileRecordImages.getFromSystemId(),fileRecordImages.getRecord().getFileAbsolutePath());
                    }
                }
            }

            if (!CollectionUtils.isEmpty(courseBaseList)){
                for (CourseBase courseBase : courseBaseList){
                    CourseBaseResult courseBaseResult = new CourseBaseResult();
                    BeanCopyUtils.copyProperties(courseBase,courseBaseResult);
                    if (imagesUrlMap.containsKey(courseBase.getCourseId())){
                        courseBaseResult.setCourseImageUrl(imagesUrlMap.get(courseBase.getCourseId()));
                    }
                    courseBaseResultMap.put(courseBaseResult.getCourseId(),courseBaseResult);
                }
            }
        }
        //所有的教学计划
        TeachPlanExample teachPlanExample = new TeachPlanExample();
        teachPlanExample.createCriteria().andCourseIdIn(ids);
        List<TeachPlan> teachPlanList = teachPlanMapper.selectByExample(teachPlanExample);
        //课程id-教学计划
        Map<Long,List<TeachPlanResult>> teachPlanResultMap = new HashMap<>();
        //教学计划id -- 教学计划信息
        Map<Long,TeachPlanResult> teachPlanMap = new HashMap<>();
        for (TeachPlan teachPlan : teachPlanList){
            TeachPlanResult teachPlanResult = new TeachPlanResult();
            BeanCopyUtils.copyProperties(teachPlan,teachPlanResult);
            if (teachPlanResultMap.containsKey(Long.valueOf(teachPlan.getCourseId()))){
                teachPlanResultMap.get(Long.valueOf(teachPlan.getCourseId())).add(teachPlanResult);
            }else {
                List<TeachPlanResult> list = new ArrayList<>();
                list.add(teachPlanResult);
                teachPlanResultMap.put(Long.valueOf(teachPlan.getCourseId()),list);
            }
            teachPlanMap.put(teachPlan.getTeachplanId(),teachPlanResult);
        }
        LearningTeachplanExample learningTeachplanExample = new LearningTeachplanExample();
        learningTeachplanExample.createCriteria().andUserIdEqualTo(param.getUserId()).andCourseIdIn(courseIds);
        List<LearningTeachplan> learningTeachplanList = learningTeachplanMapper.selectByExample(learningTeachplanExample);
        //课程id 学习资源
        Map<Long,List<LearningTeachplanResult>> learningTeachplanResultMap = new HashMap<>();
        //课程id 课程完成数
        Map<Long,Integer> courseLearningMap = new HashMap<>();
        //课程id 正在学习
        Map<Long,TeachPlanResult> learningTeachPlanMap = new HashMap<>();
        for (LearningTeachplan learningTeachplan : learningTeachplanList){
            LearningTeachplanResult learningTeachplanResult = new LearningTeachplanResult();
            BeanCopyUtils.copyProperties(learningTeachplan,learningTeachplanResult);
            if (learningTeachplanResultMap.containsKey(learningTeachplan.getCourseId())){
                learningTeachplanResultMap.get(learningTeachplan.getCourseId()).add(learningTeachplanResult);
            }else {
                List<LearningTeachplanResult> list = new ArrayList<>();
                list.add(learningTeachplanResult);
                learningTeachplanResultMap.put(learningTeachplan.getCourseId(),list);
            }
            if (StringUtils.equals(learningTeachplan.getStatus(),"0") && teachPlanMap.containsKey(learningTeachplan.getTeachplanId())){
                learningTeachPlanMap.put(learningTeachplan.getCourseId(),teachPlanMap.get(learningTeachplan.getTeachplanId()));
            }
        }
        //正在学习的
        List<PersonCourseResult> results = new ArrayList<>();
        for (LearningCourse learningCourse : learningCourseList){
            PersonCourseResult personCourseResult = new PersonCourseResult();
            if (courseBaseResultMap.containsKey(learningCourse.getCourseId())){
                CourseBaseResult courseBaseResult = new CourseBaseResult();
                BeanCopyUtils.copyProperties(courseBaseResultMap.get(learningCourse.getCourseId()),courseBaseResult);
                personCourseResult.setCourseBaseResult(courseBaseResult);
            }
            if (learningTeachPlanMap.containsKey(learningCourse.getCourseId())){
                personCourseResult.setLearningTeachPlan(learningTeachPlanMap.get(learningCourse.getCourseId()));
            }
            personCourseResult.setCreateTime(learningCourse.getCreateTime());
            personCourseResult.setStatus("继续学习");
            if (learningTeachplanResultMap.containsKey(learningCourse.getCourseId()) && teachPlanResultMap.containsKey(learningCourse.getCourseId())){
                List<LearningTeachplanResult> learningTeachplanResultList = learningTeachplanResultMap.get(learningCourse.getCourseId());
                List<TeachPlanResult> teachPlanResultList = teachPlanResultMap.get(learningCourse.getCourseId());
                if (learningTeachplanResultList.size() == teachPlanResultList.size()){
                    personCourseResult.setStatus("课程完成");
                    personCourseResult.setProgressBar(100);
                }else {
                    int count = learningTeachplanResultList.size()/teachPlanResultList.size();
                    personCourseResult.setProgressBar(count);
                }
            }
            results.add(personCourseResult);
        }

        //排序

        //每页的起始索引
        int pageNo=(commonPageInfo.getPageNum()-1)*commonPageInfo.getPageSize();
        // 每页记录数
        int pageSize=commonPageInfo.getPageSize();
        long total = results.size();
        if (pageNo+pageSize > total) {
            results = results.subList(pageNo, (int) total);
        }else {
            results = results.subList(pageNo,pageNo+pageSize);
        }
        CommonPageResult<PersonCourseResult> pageResult = CommonPageResult.build(results,commonPageInfo,total);

        return CommonResult.success(pageResult);
    }
}

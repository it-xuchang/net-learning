package com.netlearning.course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.course.client.FileRecordControllerClientApi;
import com.netlearning.course.client.FileRecordImagesControllerClientApi;
import com.netlearning.course.client.TeacherControllerClientApi;
import com.netlearning.course.mapper.*;
import com.netlearning.course.service.CourseBaseService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.*;
import com.netlearning.framework.domain.course.param.CourseBaseAddParam;
import com.netlearning.framework.domain.course.param.CourseBaseDeleteParam;
import com.netlearning.framework.domain.course.param.CourseBaseEditParam;
import com.netlearning.framework.domain.course.param.CourseBaseQueryParam;
import com.netlearning.framework.domain.course.result.*;
import com.netlearning.framework.domain.fss.result.FileRecordImagesResult;
import com.netlearning.framework.domain.fss.result.FileRecordResult;
import com.netlearning.framework.domain.userAuth.Teacher;
import com.netlearning.framework.em.CourseConstants;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.StringUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 20:55
 */
@Service
public class CourseBaseServiceImpl implements CourseBaseService {
    @Autowired
    private CourseBaseMapper courseBaseMapper;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private LearningCourseMapper learningCourseMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TeachPlanMapper teachPlanMapper;
    @Autowired
    private CourseAssessmentMapper courseAssessmentMapper;
    @Autowired
    private TeacherControllerClientApi teacherControllerClientApi;
    @Autowired
    private FileRecordControllerClientApi fileRecordControllerClientApi;
    @Autowired
    private FileRecordImagesControllerClientApi fileRecordImagesControllerClientApi;
    @Override
    public CommonResult<List<CourseBaseResult>> query(CourseBaseQueryParam param) {
        CourseBaseExample example = new CourseBaseExample();
        CourseBaseExample.Criteria criteria = example.createCriteria();
        if (param.getCourseId() != null){
            criteria.andCourseIdEqualTo(param.getCourseId());
        }
        if (param.getTeacherId() != null){
            criteria.andTeacherIdEqualTo(param.getTeacherId());
        }
        if (!StringUtils.isEmpty(param.getCourseName())){
            criteria.andCourseNameLike("%"+param.getCourseName()+"%");
        }
        if (!StringUtils.isEmpty(param.getUsers())){
            criteria.andUsersLike("%"+param.getUsers()+"%");
        }
        if (!StringUtils.isEmpty(param.getCategory())){
            criteria.andCategoryEqualTo(param.getCategory());
        }
        if (!CollectionUtils.isEmpty(param.getCouresIds())){
            criteria.andCourseIdIn(param.getCouresIds());
        }

        List<CourseBase> courseBaseList = courseBaseMapper.selectByExample(example);
        List<CourseBaseResult> courseBaseResults = BeanCopyUtils.copy(courseBaseList,CourseBaseResult.class);
        return CommonResult.success(courseBaseResults);
    }

    @Override
    public CommonResult<CommonPageResult<CourseBaseResult>> page(CourseBaseQueryParam param, CommonPageInfo commonPageInfo) {
        CourseBaseExample example = new CourseBaseExample();
        CourseBaseExample.Criteria criteria = example.createCriteria();
        if (param.getCourseId() != null){
            criteria.andCourseIdEqualTo(param.getCourseId());
        }
        if (param.getTeacherId() != null){
            criteria.andTeacherIdEqualTo(param.getTeacherId());
        }
        if (!StringUtils.isEmpty(param.getCourseName())){
            criteria.andCourseNameLike("%"+param.getCourseName()+"%");
        }
        if (!StringUtils.isEmpty(param.getUsers())){
            criteria.andUsersLike("%"+param.getUsers()+"%");
        }
        if (!StringUtils.isEmpty(param.getCategory())){
            criteria.andCategoryEqualTo(param.getCategory());
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<CourseBase> courseBaseList = (Page<CourseBase>) courseBaseMapper.selectByExample(example);
        List<CourseBaseResult> courseBaseResults = BeanCopyUtils.copy(courseBaseList,CourseBaseResult.class);
        CommonPageResult<CourseBaseResult> result = CommonPageResult.build(courseBaseResults,commonPageInfo,courseBaseList.getTotal());
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<Boolean> add(CourseBaseAddParam request) {
        CourseBase record = new CourseBase();
        BeanCopyUtils.copyProperties(request,record);
        record.setCourseId(sequenceService.nextValue(null));
        courseBaseMapper.insertSelective(record);
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> edit(CourseBaseEditParam request) {
        CourseBase record = new CourseBase();
        BeanCopyUtils.copyProperties(request,record);
        courseBaseMapper.updateByPrimaryKeySelective(record);
        return null;
    }

    @Override
    public CommonResult<Boolean> delete(CourseBaseDeleteParam request) {
        CourseBaseExample example = new CourseBaseExample();
        CourseBaseExample.Criteria criteria = example.createCriteria();
        if (!CollectionUtils.isEmpty(request.getCourseIds())){
            criteria.andCourseIdIn(request.getCourseIds());
        }
        if (request.getCourseId() != null){
            criteria.andCourseIdEqualTo(request.getCourseId());
        }
        if (request.getTeacherId()!= null){
            criteria.andTeacherIdEqualTo(request.getTeacherId());
        }
        courseBaseMapper.deleteByExample(example);
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<List<CourseRecommendationResult>> queryCourseRecommendation(Long size) {
        List<CourseRecommendation> courseRecommendationList = learningCourseMapper.countCourseByHotSize(new ArrayList<>());

        List<Long> courseIds = new ArrayList<>();
        Map<Long,Integer> countMap = new HashMap<>();
        for (CourseRecommendation courseRecommendation : courseRecommendationList){
            if (!courseIds.contains(courseRecommendation.getCourseId())){
                courseIds.add(courseRecommendation.getCourseId());
            }
            countMap.put(courseRecommendation.getCourseId(),courseRecommendation.getCount());
        }
        //课程id 文件系统的图片信息
        Map<Long,FileRecordResult> fileRecordResultMap = new HashMap<>();

        List<CourseRecommendationResult> recommendationResults = new ArrayList<>();
        if (!CollectionUtils.isEmpty(courseIds)){
            //调用文件系统的微服务 根据课程id
//            CommonResult<List<FileRecordResult>> fileRecordResult = fileRecordControllerClientApi.queryByFromSystemIds(courseIds);
            CommonResult<List<FileRecordImagesResult>> fileRecordResult =  fileRecordImagesControllerClientApi.query(courseIds);
            if (fileRecordResult.isSuccess()){
                for (FileRecordImagesResult fileRecord : fileRecordResult.getData()){
                    if (!fileRecordResultMap.containsKey(fileRecord.getRecord().getFromSystemId())
                            && fileRecord.getRecord().getFromSystemId() != null
                            && fileRecord.getRecord() != null){
                        fileRecordResultMap.put(fileRecord.getRecord().getFromSystemId(),fileRecord.getRecord());
                    }
                }
            }
            CourseBaseExample example = new CourseBaseExample();
            example.createCriteria().andCourseIdIn(courseIds).andStatusEqualTo(CourseConstants.CourseType.RELEASE.getCode());
            List<CourseBase> courseBaseList = courseBaseMapper.selectByExample(example);
            for (CourseBase courseBase : courseBaseList){
                CourseRecommendationResult recommendationResult = new CourseRecommendationResult();
                recommendationResult.setCourseGrdle(courseBase.getGrade());
                recommendationResult.setCourseId(courseBase.getCourseId());
                recommendationResult.setCourseName(courseBase.getCourseName());
                if (countMap.containsKey(courseBase.getCourseId())){
                    recommendationResult.setLearningUser(countMap.get(courseBase.getCourseId()));
                }

                if (fileRecordResultMap.containsKey(courseBase.getCourseId())){
                    recommendationResult.setCourseImageUrl(fileRecordResultMap.get(courseBase.getCourseId()).getFileAbsolutePath());
                }else {
                    recommendationResult.setCourseImageUrl("");
                }
                recommendationResults.add(recommendationResult);
            }
        }
        if (recommendationResults.size()>size && size != null){
            recommendationResults.subList(0, (int) (size-1));
        }
        return CommonResult.success(recommendationResults);
    }


    @Override
    public CommonResult<List<RecommendedCourseDirectionResult>> queryRecommendedCourseDirection(Long size, Long categoryId, String grade) {

       if (size == null || size == 0){
           return CommonResult.fail("","size输入有误");
       }

        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria categoryExampleCriteria = categoryExample.createCriteria();
        categoryExampleCriteria.andIsShowEqualTo(CourseConstants.CategoryType.SHOW.getCode());
        categoryExampleCriteria.andIsLeafEqualTo(CourseConstants.CategoryType.LEAF.getCode());
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        List<String> categoryIds = new ArrayList<>();
        for (Category category : categoryList){
            if (!categoryIds.contains(String.valueOf(category.getCategoryId()))){
                categoryIds.add(String.valueOf(category.getCategoryId()));
            }
        }
        CourseBaseExample courseBaseExample = new CourseBaseExample();
        CourseBaseExample.Criteria courseBaseExampleCriteria = courseBaseExample.createCriteria();
        courseBaseExampleCriteria.andStatusEqualTo(CourseConstants.CourseType.RELEASE.getCode());
        courseBaseExampleCriteria.andCategoryIn(categoryIds);
        List<CourseBase> courseBaseList = courseBaseMapper.selectByExample(courseBaseExample);
        //分类id 课程
        Map<String,List<CourseBase>> categoryCourseMap = new HashMap<>();
        List<Long> courseIds = new ArrayList<>();
        for (CourseBase courseBase : courseBaseList){
            if (!courseIds.contains(courseBase.getCourseId())){
                courseIds.add(courseBase.getCourseId());
            }

            if (categoryCourseMap.containsKey(courseBase.getCategory())){
                categoryCourseMap.get(courseBase.getCategory()).add(courseBase);
            }else {
                List<CourseBase> list = new ArrayList<>();
                list.add(courseBase);
                categoryCourseMap.put(courseBase.getCategory(),list);
            }
        }
        List<CourseRecommendation> courseRecommendationList = learningCourseMapper.countCourseByHotSize(courseIds);

        //课程id 文件系统的图片信息
        Map<Long,FileRecordResult> fileRecordResultMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(courseIds)){
            //调用文件系统的微服务 根据课程id
//            CommonResult<List<FileRecordResult>> fileRecordResult = fileRecordControllerClientApi.queryByFromSystemIds(courseIds);
            CommonResult<List<FileRecordImagesResult>> fileRecordResult =  fileRecordImagesControllerClientApi.query(courseIds);
            if (fileRecordResult.isSuccess()){
                for (FileRecordImagesResult fileRecord : fileRecordResult.getData()){
                    if (!fileRecordResultMap.containsKey(fileRecord.getRecord().getFromSystemId()) && fileRecord.getRecord().getFromSystemId() != null){
                        fileRecordResultMap.put(fileRecord.getRecord().getFromSystemId(),fileRecord.getRecord());
                    }
                }
            }
        }
        //课程id 统计
        Map<Long,Integer> countMap = new HashMap<>();
        for (CourseRecommendation courseRecommendation : courseRecommendationList){
            countMap.put(courseRecommendation.getCourseId(),courseRecommendation.getCount());
        }
        //分类id List<CourseDirectionResult>
        Map<Long,List<CourseDirectionResult>> courseDirectionMap = new HashMap<>();
        for (Map.Entry<String,List<CourseBase>> entry : categoryCourseMap.entrySet()){
            String key = entry.getKey();
            List<CourseBase> value = entry.getValue();
            List<CourseBase> courseBases = new ArrayList<>();
            if (value.size() >= size && size != null){
                courseBases = value.subList(0, Math.toIntExact(size));
            }else {
                courseBases.addAll(value);
            }
            List<CourseDirectionResult> courseDirectionResults = new ArrayList<>();
            for (CourseBase course : courseBases){
                CourseDirectionResult courseDirection = new CourseDirectionResult();
                courseDirection.setCourseGrdle(course.getGrade());
                courseDirection.setCourseId(course.getCourseId());
                if (fileRecordResultMap.containsKey(course.getCourseId())){
                    courseDirection.setCourseImageUrl(fileRecordResultMap.get(course.getCourseId()).getFileAbsolutePath());
                }else {
                    courseDirection.setCourseImageUrl("");
                }
                courseDirection.setCourseName(course.getCourseName());
                if (countMap.containsKey(course.getCourseId())){
                    courseDirection.setLearningUser(countMap.get(course.getCourseId()));
                }
                courseDirectionResults.add(courseDirection);
            }
            courseDirectionMap.put(Long.valueOf(key),courseDirectionResults);
        }

        List<RecommendedCourseDirectionResult> recommendedCourseDirectionResults = new ArrayList<>();

        //调用文件系统获取过个图片的url
        for (Category category : categoryList){
            RecommendedCourseDirectionResult recommendedCourseDirectionResult = new RecommendedCourseDirectionResult();
            recommendedCourseDirectionResult.setHeaderImageUrl("");
            recommendedCourseDirectionResult.setLeftImageUrl("");
            recommendedCourseDirectionResult.setCourseDirectionName(category.getCategoryName());
            if (courseDirectionMap.containsKey(category.getCategoryId())){
                recommendedCourseDirectionResult.setCourseItem(courseDirectionMap.get(category.getCategoryId()));
            }
            recommendedCourseDirectionResults.add(recommendedCourseDirectionResult);

        }
        return CommonResult.success(recommendedCourseDirectionResults);
    }

    @Override
    public CommonResult<CourseBaseDetailResult> queryCouresDetail(CourseBaseQueryParam param) {

        if (param.getCourseId() == null){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE009.code,ExceptionCode.CourseCode.CODE009.message);
        }
        CourseBaseDetailResult courseBaseDetailResult = new CourseBaseDetailResult();
        //课程信息
        CourseBaseExample courseBaseExample = new CourseBaseExample();
        courseBaseExample.createCriteria().andCourseIdEqualTo(param.getCourseId());
        List<CourseBase> courseBaseList = courseBaseMapper.selectByExampleWithBLOBs(courseBaseExample);
        if (CollectionUtils.isEmpty(courseBaseList)){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE008.code,ExceptionCode.CourseCode.CODE008.message);
        }
        BeanCopyUtils.copyProperties(courseBaseList.get(0),courseBaseDetailResult);
        //课程时长
        TeachPlanExample teachPlanExample = new TeachPlanExample();
        teachPlanExample.createCriteria().andCourseIdEqualTo(String.valueOf(param.getCourseId()));
        List<TeachPlan> teachPlanList = teachPlanMapper.selectByExample(teachPlanExample);
        if (CollectionUtils.isEmpty(teachPlanList)){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE010.code,ExceptionCode.CourseCode.CODE010.message);
        }
        List<Double> allTeachPlanTime = new ArrayList<>();
        Double countTeachPlanTime = 0.0;
        for (TeachPlan teachPlan : teachPlanList){
            if (teachPlan.getTimeLength() != null){
                allTeachPlanTime.add(teachPlan.getTimeLength());
            }
        }
        for (Double time : allTeachPlanTime){
            countTeachPlanTime += time;
        }
        courseBaseDetailResult.setCourseCountTime(countTeachPlanTime);

        //课程评分
        CourseAssessmentExample courseAssessmentExample = new CourseAssessmentExample();
        courseAssessmentExample.createCriteria().andCourseIdEqualTo(param.getCourseId());
        List<CourseAssessment> courseAssessmentList = courseAssessmentMapper.selectByExample(courseAssessmentExample);
        List<Double> allUserAssessmentGrade = new ArrayList<>();
        if (!CollectionUtils.isEmpty(courseAssessmentList)){
            for (CourseAssessment courseAssessment : courseAssessmentList){
                if (courseAssessment.getCourseAssessmentGrade() != null){
                    allUserAssessmentGrade.add(courseAssessment.getCourseAssessmentGrade());
                }
            }
        }
        Double courseAssessmentGrade = 0.0;
        for (Double grade : allUserAssessmentGrade){
            courseAssessmentGrade += grade;
        }
        courseBaseDetailResult.setCourseAssessmentGrade(courseAssessmentGrade/allUserAssessmentGrade.size());
        //课程教师
        Long teacherId = courseBaseList.get(0).getTeacherId();
        CommonResult<List<Teacher>> teacherResult = teacherControllerClientApi.query(teacherId);
        if (teacherResult.isSuccess() && !CollectionUtils.isEmpty(teacherResult.getData())){
            Teacher teacher = teacherResult.getData().get(0);
            courseBaseDetailResult.setTeacher(teacher);
        }

        return CommonResult.success(courseBaseDetailResult);
    }
}

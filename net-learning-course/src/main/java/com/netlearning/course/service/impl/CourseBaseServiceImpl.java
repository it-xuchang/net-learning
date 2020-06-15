package com.netlearning.course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.course.client.*;
import com.netlearning.course.mapper.*;
import com.netlearning.course.service.CourseBaseService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.*;
import com.netlearning.framework.domain.course.param.*;
import com.netlearning.framework.domain.course.result.*;
import com.netlearning.framework.domain.fss.result.FileRecordImagesResult;
import com.netlearning.framework.domain.fss.result.FileRecordResourcesResult;
import com.netlearning.framework.domain.fss.result.FileRecordResult;
import com.netlearning.framework.domain.userAuth.result.TeacherResult;
import com.netlearning.framework.domain.userAuth.result.UserResult;
import com.netlearning.framework.em.CourseConstants;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private FrequentlyAskedQuestionMapper frequentlyAskedQuestionMapper;
    @Autowired
    private CourseQuziMapper courseQuziMapper;
    @Autowired
    private UserControllerClientApi userControllerClientApi;
    @Autowired
    private FileRecordResourcesControllerClientApi fileRecordResourcesControllerClientApi;
    @Autowired
    private TeachPlanMediaMapper teachPlanMediaMapper;
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

        List<CourseBase> courseBaseList = courseBaseMapper.selectByExampleWithBLOBs(example);
        List<Long> courseIds = new ArrayList<>();
        for (CourseBase courseBase : courseBaseList){
            if (!courseIds.contains(courseBase.getCourseId())){
                courseIds.add(courseBase.getCourseId());
            }
        }
        Map<Long,String> courseImagesMap = new HashMap<>();
        CommonResult<List<FileRecordImagesResult>> fileResordImagesResult = fileRecordImagesControllerClientApi.query(courseIds);
        if (fileResordImagesResult.isSuccess()){
            for (FileRecordImagesResult fileRecordImages : fileResordImagesResult.getData()){
                if (!courseImagesMap.containsKey(fileRecordImages.getFromSystemId())){
                    courseImagesMap.put(fileRecordImages.getFromSystemId(),fileRecordImages.getRecord().getFileAbsolutePath());
                }
            }
        }
        List<CourseBaseResult> courseBaseResults = BeanCopyUtils.copy(courseBaseList,CourseBaseResult.class);
        for (CourseBaseResult courseBase : courseBaseResults){
            if (courseImagesMap.containsKey(courseBase.getCourseId())){
                courseBase.setCourseImageUrl(courseImagesMap.get(courseBase.getCourseId()));
            }
        }
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
        if (!StringUtils.isEmpty(param.getGrade())){
            criteria.andGradeEqualTo(param.getGrade());
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<CourseBase> courseBaseList = (Page<CourseBase>) courseBaseMapper.selectByExampleWithBLOBs(example);
        List<CourseBaseResult> courseBaseResults = BeanCopyUtils.copy(courseBaseList,CourseBaseResult.class);
        List<Long> courseIds = new ArrayList<>();
        for (CourseBaseResult courseBase : courseBaseResults){
            if (!courseIds.contains(courseBase.getCourseId())){
                courseIds.add(courseBase.getCourseId());
            }
        }
        Map<Long,String> courseImagesMap = new HashMap<>();
        CommonResult<List<FileRecordImagesResult>> fileResordImagesResult = fileRecordImagesControllerClientApi.query(courseIds);
        if (fileResordImagesResult.isSuccess()){
            for (FileRecordImagesResult fileRecordImages : fileResordImagesResult.getData()){
                if (!courseImagesMap.containsKey(fileRecordImages.getFromSystemId())){
                    courseImagesMap.put(fileRecordImages.getFromSystemId(),fileRecordImages.getRecord().getFileAbsolutePath());
                }
            }
        }
        for (CourseBaseResult courseBase : courseBaseResults){
            if (courseImagesMap.containsKey(courseBase.getCourseId())){
                courseBase.setCourseImageUrl(courseImagesMap.get(courseBase.getCourseId()));
            }
        }
        CommonPageResult<CourseBaseResult> result = CommonPageResult.build(courseBaseResults,commonPageInfo,courseBaseList.getTotal());
        return CommonResult.success(result);
    }

    @Override
    @Transactional
    public CommonResult add(CourseBaseAddParam request) {
        try {
            CourseBase record = new CourseBase();
            BeanCopyUtils.copyProperties(request,record);
            record.setCourseId(sequenceService.nextValue(null));
            record.setStatus(CourseConstants.CourseType.UPLOAD_IMAGES.getCode());
            courseBaseMapper.insertSelective(record);
            return CommonResult.success(record);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE002.code,ExceptionCode.CourseCode.CODE002.message);
        }

    }

    @Override
    public CommonResult<Boolean> edit(CourseBaseEditParam request) {
        try {
            CourseBase record = new CourseBase();
            BeanCopyUtils.copyProperties(request,record);
            courseBaseMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE003.code,ExceptionCode.CourseCode.CODE003.message);
        }

    }
    @Transactional
    @Override
    public CommonResult<Boolean> delete(CourseBaseDeleteParam request) {

        try {
            TeachPlanExample teachPlanExample = new TeachPlanExample();
            teachPlanExample.createCriteria().andCourseIdEqualTo(String.valueOf(request.getCourseId()));
            teachPlanMapper.deleteByExample(teachPlanExample);
            FrequentlyAskedQuestionExample frequentlyAskedQuestionExample = new FrequentlyAskedQuestionExample();
            frequentlyAskedQuestionExample.createCriteria().andCourseIdEqualTo(request.getCourseId());
            frequentlyAskedQuestionMapper.deleteByExample(frequentlyAskedQuestionExample);
            CourseQuziExample courseQuziExample = new CourseQuziExample();
            courseQuziExample.createCriteria().andCourseIdEqualTo(request.getCourseId());
            courseQuziMapper.deleteByExample(courseQuziExample);
            courseBaseMapper.deleteByPrimaryKey(request.getCourseId());
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE004.code,ExceptionCode.CourseCode.CODE004.message);
        }
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
        CommonResult<List<TeacherResult>> teacherResult = teacherControllerClientApi.query(teacherId);
        if (teacherResult.isSuccess() && !CollectionUtils.isEmpty(teacherResult.getData())){
            TeacherResult teacher = teacherResult.getData().get(0);
            courseBaseDetailResult.setTeacher(teacher);
        }

        return CommonResult.success(courseBaseDetailResult);
    }

    @Override
    public CommonResult<CourseAllDetailResult> queryCourseAllDetail(CourseAllDetailParam param) {
        CourseAllDetailResult courseAllDetailResult = new CourseAllDetailResult();

        //获取课程信息
        CourseBaseResult courseBaseResult = this.getCourseResult(param);
        courseAllDetailResult.setCourseBaseResult(courseBaseResult);
        //获取教师信息
        TeacherResult teacherResult = this.getTeacherResult(param,courseBaseResult);
        courseAllDetailResult.setTeacherResult(teacherResult);
        //获取分类信息
        CategoryResult categoryResult = this.getCategoryResult(param,courseBaseResult);
        courseAllDetailResult.setCategoryResult(categoryResult);
        //获取教学计划
        List<TeachPlan> teachPlans = this.getTeachPlan(param,courseBaseResult);
        List<TeachPlanResult> teachPlanResults = this.getTeachPlanResult(teachPlans);
        courseAllDetailResult.setTeachPlans(teachPlanResults);
        List<Double> allTeachPlanTime = new ArrayList<>();
        Double countTeachPlanTime = 0.0;
        for (TeachPlan teachPlan : teachPlans){
            if (teachPlan.getTimeLength() != null){
                allTeachPlanTime.add(teachPlan.getTimeLength());
            }
        }
        for (Double time : allTeachPlanTime){
            countTeachPlanTime += time;
        }
        courseAllDetailResult.setCourseCountTime(countTeachPlanTime);
        //获取常见问题
        List<FrequentlyAskedQuestionResult> frequentlyAskedQuestionResults = this.getFrequentAskedQuestionResult(param);
        courseAllDetailResult.setFrequentlyAskedQuestionResults(frequentlyAskedQuestionResults);
        //获取课程评价
        List<CourseAssessmentResult> courseAssessmentResults = this.getCourseAssessmentResult(param);
        courseAllDetailResult.setCourseAssessmentResults(courseAssessmentResults);
        List<Double> allUserAssessmentGrade = new ArrayList<>();
        if (!CollectionUtils.isEmpty(courseAssessmentResults)){
            for (CourseAssessmentResult courseAssessment : courseAssessmentResults){
                if (courseAssessment.getCourseAssessmentGrade() != null){
                    allUserAssessmentGrade.add(courseAssessment.getCourseAssessmentGrade());
                }
            }
        }
        Double courseAssessmentGrade = 0.0;
        for (Double grade : allUserAssessmentGrade){
            courseAssessmentGrade += grade;
        }
        if (!CollectionUtils.isEmpty(allUserAssessmentGrade)){
            courseAssessmentGrade = courseAssessmentGrade/allUserAssessmentGrade.size();
        }
        courseAllDetailResult.setCourseAssessmentGrade(courseAssessmentGrade);
        //获取课程问答
        List<CourseQuziResult> courseQuziResults = this.getCourseQuziResult(param);
        courseAllDetailResult.setCourseQuziResults(courseQuziResults);

        //查询课程学习是否存在
        LearningCourseExample example = new LearningCourseExample();
        LearningCourseExample.Criteria criteria = example.createCriteria();
        if (param.getCourseId() != null){
            criteria.andCourseIdEqualTo(param.getCourseId());
        }
        if (param.getUserId() != null){
            criteria.andUserIdEqualTo(param.getUserId());
        }
        List<LearningCourse> learningCourseList = learningCourseMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(learningCourseList)){
            courseAllDetailResult.setLearning(true);
        }
        return CommonResult.success(courseAllDetailResult);
    }

    @Override
    @Transactional
    public CommonResult<Boolean> changeStatus(CourseBaseEditParam request) {
        try {
            CourseBase record = new CourseBase();
            BeanCopyUtils.copyProperties(request,record);
            courseBaseMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE002.code,ExceptionCode.CourseCode.CODE002.message);
        }
    }

    private List<TeachPlanResult> getTeachPlanResult(List<TeachPlan> teachPlans) {
        List<TeachPlanResult> results = BeanCopyUtils.copy(teachPlans,TeachPlanResult.class);
        List<Long> teachplanIds = new ArrayList<>();

        for (TeachPlanResult teachPlan : results){
            if (!teachplanIds.contains(teachPlan.getTeachplanId())){
                teachplanIds.add(teachPlan.getTeachplanId());
            }
        }
        Map<Long,List<TeachPlanMedia>> teachplanMediaMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(teachplanIds)){
            TeachPlanMediaExample example = new TeachPlanMediaExample();
           TeachPlanMediaExample.Criteria criteria = example.createCriteria();
           criteria.andTeachplanIdIn(teachplanIds);

            List<TeachPlanMedia> teachPlanMediaList = teachPlanMediaMapper.selectByExample(example);
            for (TeachPlanMedia teachPlanMedia : teachPlanMediaList){
                if (teachplanMediaMap.containsKey(teachPlanMedia.getTeachplanId())){
                    teachplanMediaMap.get(teachPlanMedia.getTeachplanId()).add(teachPlanMedia);
                }else {
                    List<TeachPlanMedia> list = new ArrayList<>();
                    list.add(teachPlanMedia);
                    teachplanMediaMap.put(teachPlanMedia.getTeachplanId(),list);
                }
            }
        }

//        for (TeachPlanResult teachPlan : results){
//            if (teachplanMediaMap.containsKey(teachPlan.getTeachplanId())){
//                teachPlan.setMediaUrl(teachplanMediaMap.get(teachPlan.getTeachplanId()).getMediaUrl());
//            }
//        }
        return getTreeTeachPlan(results,teachplanMediaMap);
    }
    /**
     * 教学计划--教学资源
     * @param teachPlanResults
     * @param teachPlanMediaMap
     * @return
     */
    private List<TeachPlanResult> getTreeTeachPlan(List<TeachPlanResult> teachPlanResults,
                                                   Map<Long, List<TeachPlanMedia>> teachPlanMediaMap){
        List<TeachPlanResult> results = new ArrayList<>();
        //第一层
        Map<Long,TeachPlanResult> oneTree = new HashMap<>();
        for (TeachPlanResult teachPlanResult : teachPlanResults){
            if (teachPlanMediaMap.containsKey(teachPlanResult.getTeachplanId())){
                List<TeachPlanMediaResult> list = BeanCopyUtils.copy(teachPlanMediaMap.get(teachPlanResult.getTeachplanId()),TeachPlanMediaResult.class);
                teachPlanResult.setTeachPlanMediaResults(list);
            }

            if (teachPlanResult.getParentId() == null){
                if (!oneTree.containsKey(teachPlanResult.getTeachplanId())){
                    oneTree.put(teachPlanResult.getTeachplanId(),teachPlanResult);
                }
            }
        }
        //第二层
        Map<Long,List<TeachPlanResult>> twoTree = new HashMap<>();
        for (TeachPlanResult teachPlanResult : teachPlanResults){
            if (oneTree.containsKey(teachPlanResult.getParentId())){
                if (twoTree.containsKey(teachPlanResult.getParentId())){
                    twoTree.get(teachPlanResult.getParentId()).add(teachPlanResult);
                }else {
                    List<TeachPlanResult> list = new ArrayList<>();
                    list.add(teachPlanResult);
                    twoTree.put(teachPlanResult.getParentId(),list);
                }
            }
        }
        //第三层
        Map<Long,List<TeachPlanResult>> threeTree = new HashMap<>();
        for (Map.Entry<Long,List<TeachPlanResult>> twoEntey : twoTree.entrySet()){
            List<TeachPlanResult> twoTreeVlaue = twoEntey.getValue();
            for (TeachPlanResult twoMenu : twoTreeVlaue){
                Long twoKey = twoMenu.getTeachplanId();
                for (TeachPlanResult teachPlanResult : teachPlanResults){
                    if (twoKey.equals(teachPlanResult.getParentId())){
                        if (threeTree.containsKey(twoKey)){
                            threeTree.get(twoKey).add(teachPlanResult);
                        }else {
                            List<TeachPlanResult> list = new ArrayList<>();
                            list.add(teachPlanResult);
                            threeTree.put(twoKey,list);
                        }
                    }
                }
            }
        }
        //封装返回
        for (Map.Entry<Long,TeachPlanResult> oneEntry : oneTree.entrySet()){
            TeachPlanResult oneTreeMenu = new TeachPlanResult();
            Long oneKey = oneEntry.getKey();
            TeachPlanResult oneValue = oneEntry.getValue();
            BeanCopyUtils.copyProperties(oneValue,oneTreeMenu);
            if (twoTree.containsKey(oneKey)){
                List<TeachPlanResult> twoMenus = twoTree.get(oneKey);
                List<TeachPlanResult> twoMenuItems = BeanCopyUtils.copy(twoMenus,TeachPlanResult.class);
                if (CollectionUtils.isEmpty(twoMenuItems)){
                    oneTreeMenu.setSubTeachPlanResult(new ArrayList<>());
                }else {
                    oneTreeMenu.setSubTeachPlanResult(twoMenuItems);
                }

                for (TeachPlanResult twoMenu : twoMenuItems){
                    if (threeTree.containsKey(twoMenu.getTeachplanId())){
                        List<TeachPlanResult> threeMenus = threeTree.get(twoMenu.getTeachplanId());
                        List<TeachPlanResult> threeMenuItems = BeanCopyUtils.copy(threeMenus,TeachPlanResult.class);
                        if (CollectionUtils.isEmpty(threeMenuItems)){
                            twoMenu.setSubTeachPlanResult(new ArrayList<>());
                        }else {
                            twoMenu.setSubTeachPlanResult(threeMenuItems);
                        }

                    }
                }
            }else {
                oneTreeMenu.setSubTeachPlanResult(new ArrayList<>());
            }
            results.add(oneTreeMenu);
        }


        return results;
    }
    private CategoryResult getCategoryResult(CourseAllDetailParam param, CourseBaseResult courseBaseResult) {

        CategoryExample example = new CategoryExample();
        if (!StringUtils.isEmpty(courseBaseResult.getCategory())){
            example.createCriteria().andCategoryIdEqualTo(Long.valueOf(courseBaseResult.getCategory()));
        }
        CategoryResult categoryResult = new CategoryResult();
        List<Category> categoryList = categoryMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(categoryList)){
            BeanCopyUtils.copyProperties(categoryList.get(0),categoryResult);
        }
        return categoryResult;
    }

    private List<TeachPlan> getTeachPlan(CourseAllDetailParam param, CourseBaseResult courseBaseResult) {

        Long teacherId = courseBaseResult.getTeacherId();
        TeachPlanExample example = new TeachPlanExample();
        TeachPlanExample.Criteria criteria = example.createCriteria();
        if (param.getCourseId() != null){
            criteria.andCourseIdEqualTo(String.valueOf(param.getCourseId()));
        }
        List<TeachPlan> teachPlanList = teachPlanMapper.selectByExample(example);
        return teachPlanList;
    }

    private List<FrequentlyAskedQuestionResult> getFrequentAskedQuestionResult(CourseAllDetailParam param) {
        FrequentlyAskedQuestionExample example = new FrequentlyAskedQuestionExample();
        if (param.getCourseId() != null){
            example.createCriteria().andCourseIdEqualTo(param.getCourseId());
        }
        example.setOrderByClause("create_time desc");
        List<FrequentlyAskedQuestion> frequentlyAskedQuestionList = frequentlyAskedQuestionMapper.selectByExample(example);
        List<FrequentlyAskedQuestionResult> results = BeanCopyUtils.copy(frequentlyAskedQuestionList,FrequentlyAskedQuestionResult.class);
        return results;
    }

    private List<CourseAssessmentResult> getCourseAssessmentResult(CourseAllDetailParam param) {

        CourseAssessmentExample example = new CourseAssessmentExample();
        if (param.getCourseId() != null){
            example.createCriteria().andCourseIdEqualTo(param.getCourseId());
        }
        example.setOrderByClause("create_time desc");
        List<CourseAssessment> courseAssessmentList = courseAssessmentMapper.selectByExample(example);
        List<CourseAssessmentResult> results = new ArrayList<>();
        List<Long> userIds = new ArrayList<>();
        for (CourseAssessment courseAssessmentResult : courseAssessmentList){
            if (!userIds.contains(courseAssessmentResult.getUserId())){
                userIds.add(courseAssessmentResult.getUserId());
            }
        }
        CommonResult<List<UserResult>> userResult = userControllerClientApi.query(userIds);
        Map<Long,UserResult> userResultMap = new HashMap<>();
        if (userResult.isSuccess()){
            List<UserResult> userResultList = userResult.getData();
            for (UserResult result : userResultList){
                if (!userResultMap.containsKey(result.getUserId())){
                    userResultMap.put(result.getUserId(),result);
                }
            }
        }
        for (CourseAssessment courseAssessment : courseAssessmentList){
            CourseAssessmentResult courseAssessmentResult = new CourseAssessmentResult();
            BeanCopyUtils.copyProperties(courseAssessment,courseAssessmentResult);
            if (userResultMap.containsKey(courseAssessment.getUserId())){
                courseAssessmentResult.setUserResult(userResultMap.get(courseAssessment.getUserId()));
            }
            results.add(courseAssessmentResult);
        }

        return results;
    }

    private List<CourseQuziResult> getCourseQuziResult(CourseAllDetailParam param) {
        CourseQuziExample example = new CourseQuziExample();
        if (param.getCourseId() != null){
            example.createCriteria().andCourseIdEqualTo(param.getCourseId());
        }
        example.setOrderByClause("is_over_head desc,create_time desc");
        List<CourseQuzi> courseQuziList = courseQuziMapper.selectByExample(example);

        List<CourseQuziResult> results = BeanCopyUtils.copy(courseQuziList,CourseQuziResult.class);
        return results;
    }

    private TeacherResult getTeacherResult(CourseAllDetailParam param, CourseBaseResult courseBaseResult) {
        Long teacherId = courseBaseResult.getTeacherId();
        CommonResult<List<TeacherResult>> teacherResult = teacherControllerClientApi.query(teacherId);
        TeacherResult result = new TeacherResult();
        if (teacherResult.isSuccess()){
            if (!CollectionUtils.isEmpty(teacherResult.getData())){
                BeanCopyUtils.copyProperties(teacherResult.getData().get(0),result);
            }
        }

        return result;
    }

    private CourseBaseResult getCourseResult(CourseAllDetailParam param) {
        CourseBaseExample example = new CourseBaseExample();
        CourseBaseExample.Criteria criteria = example.createCriteria();
        if (param.getCourseId() != null){
            criteria.andCourseIdEqualTo(param.getCourseId());
        }
        criteria.andStatusEqualTo(CourseConstants.CourseType.RELEASE.getCode());
        CourseBaseResult courseBaseResult = new CourseBaseResult();
        List<CourseBase> courseBaseList = courseBaseMapper.selectByExampleWithBLOBs(example);
        if (!CollectionUtils.isEmpty(courseBaseList)){
            BeanCopyUtils.copyProperties(courseBaseList.get(0),courseBaseResult);
        }
        List<Long> courseIds = new ArrayList<>();
        courseIds.add(param.getCourseId());
        CommonResult<List<FileRecordImagesResult>> imagesResult = fileRecordImagesControllerClientApi.query(courseIds);
        if (imagesResult.isSuccess()){
            courseBaseResult.setCourseImageUrl(imagesResult.getData().get(0).getRecord().getFileAbsolutePath());
        }
        return courseBaseResult;
    }
}

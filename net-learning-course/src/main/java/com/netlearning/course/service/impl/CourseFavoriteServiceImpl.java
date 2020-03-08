package com.netlearning.course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.course.client.FileRecordImagesControllerClientApi;
import com.netlearning.course.mapper.CourseBaseMapper;
import com.netlearning.course.mapper.CourseFavoriteMapper;
import com.netlearning.course.service.CourseFavoriteService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.CourseBase;
import com.netlearning.framework.domain.course.CourseBaseExample;
import com.netlearning.framework.domain.course.CourseFavorite;
import com.netlearning.framework.domain.course.CourseFavoriteExample;
import com.netlearning.framework.domain.course.param.CourseFavoriteAddParam;
import com.netlearning.framework.domain.course.param.CourseFavoriteDeleteParam;
import com.netlearning.framework.domain.course.param.CourseFavoriteQueryParam;
import com.netlearning.framework.domain.course.result.CourseBaseResult;
import com.netlearning.framework.domain.course.result.CourseFavoriteResult;
import com.netlearning.framework.domain.fss.result.FileRecordImagesResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/2/12 16:30
 */
@Service
public class CourseFavoriteServiceImpl implements CourseFavoriteService {
    @Autowired
    private CourseFavoriteMapper courseFavoriteMapper;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private CourseBaseMapper courseBaseMapper;
    @Autowired
    private FileRecordImagesControllerClientApi fileRecordImagesControllerClientApi;
    @Override
    public CommonResult add(CourseFavoriteAddParam param) {
        if (param.getCourseId() == null ){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE012.code,ExceptionCode.CourseCode.CODE012.message);
        }
        if (param.getUserId() == null){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE013.code,ExceptionCode.CourseCode.CODE013.message);
        }
        CourseFavoriteExample example = new CourseFavoriteExample();
        CourseFavoriteExample.Criteria criteria = example.createCriteria();
        criteria.andCourseIdEqualTo(param.getCourseId());
        criteria.andUserIdEqualTo(param.getUserId());

        List<CourseFavorite> courseFavoriteList = courseFavoriteMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(courseFavoriteList)){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE015.code,ExceptionCode.CourseCode.CODE015.message);
        }
        CourseFavorite record = new CourseFavorite();
        BeanCopyUtils.copyProperties(param,record);
        record.setCreateTime(new Date());
        record.setCourseFavoriteId(sequenceService.nextValue(null));
        courseFavoriteMapper.insertSelective(record);
        return CommonResult.success(true);
    }

    @Override
    public CommonResult delete(CourseFavoriteDeleteParam param) {
        courseFavoriteMapper.deleteByPrimaryKey(param.getCourseFavoriteId());
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<CommonPageResult<CourseFavoriteResult>> page(CourseFavoriteQueryParam param, CommonPageInfo commonPageInfo) {

        CourseFavoriteExample example = new CourseFavoriteExample();
        CourseFavoriteExample.Criteria criteria = example.createCriteria();
        if (param.getCourseId() != null){
            criteria.andCourseIdEqualTo(param.getCourseId());
        }
        if (param.getUserId() != null){
            criteria.andUserIdEqualTo(param.getUserId());
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<CourseFavorite> courseFavorites = (Page<CourseFavorite>) courseFavoriteMapper.selectByExample(example);

        List<CourseFavorite> courseFavoriteList = courseFavorites.getResult();
        List<Long> courseIds = new ArrayList<>();
        for (CourseFavorite courseFavorite : courseFavoriteList){
            if (!courseIds.contains(courseFavorite.getCourseId())){
                courseIds.add(courseFavorite.getCourseId());
            }
        }
        CourseBaseExample courseBaseExample = new CourseBaseExample();
        CourseBaseExample.Criteria courseBaseExampleCriteria = courseBaseExample.createCriteria();
        if (!CollectionUtils.isEmpty(courseIds)){
            courseBaseExampleCriteria.andCourseIdIn(courseIds);
        }
        List<CourseBase> courseBaseList = courseBaseMapper.selectByExampleWithBLOBs(courseBaseExample);
        List<CourseBaseResult> courseBaseResultList = BeanCopyUtils.copy(courseBaseList,CourseBaseResult.class);
        Map<Long,String> imageUrl = new HashMap<>();
        CommonResult<List<FileRecordImagesResult>> fileRecordImagesResult = fileRecordImagesControllerClientApi.query(courseIds);
        if (fileRecordImagesResult.isSuccess()){
            for (FileRecordImagesResult fileRecordImages : fileRecordImagesResult.getData()){
                if (!imageUrl.containsKey(fileRecordImages.getFromSystemId())){
                    imageUrl.put(fileRecordImages.getFromSystemId(),fileRecordImages.getRecord().getFileAbsolutePath());
                }
            }
        }
        Map<Long,CourseBaseResult> courseBaseResultMap = new HashMap<>();
        for (CourseBaseResult courseBaseResult : courseBaseResultList){
            if (imageUrl.containsKey(courseBaseResult.getCourseId())){
                courseBaseResult.setCourseImageUrl(imageUrl.get(courseBaseResult.getCourseId()));
            }
            if (!courseBaseResultMap.containsKey(courseBaseResult.getCourseId())){
                courseBaseResultMap.put(courseBaseResult.getCourseId(),courseBaseResult);
            }
        }
        List<CourseFavoriteResult> courseFavoriteResultList = BeanCopyUtils.copy(courseFavoriteList,CourseFavoriteResult.class);
        for (CourseFavoriteResult courseFavoriteResult : courseFavoriteResultList){
            if (courseBaseResultMap.containsKey(courseFavoriteResult.getCourseId())){
                courseFavoriteResult.setCourseBase(courseBaseResultMap.get(courseFavoriteResult.getCourseId()));
            }
        }
        CommonPageResult<CourseFavoriteResult> pageResult = CommonPageResult.build(courseFavoriteResultList,commonPageInfo,courseFavorites.getTotal());

        return CommonResult.success(pageResult);
    }
}

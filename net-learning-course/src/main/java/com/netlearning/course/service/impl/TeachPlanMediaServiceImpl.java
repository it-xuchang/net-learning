package com.netlearning.course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.course.mapper.TeachPlanMediaMapper;
import com.netlearning.course.service.TeachPlanMediaService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.TeachPlanMedia;
import com.netlearning.framework.domain.course.TeachPlanMediaExample;
import com.netlearning.framework.domain.course.param.TeachPlanMediaAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaDeleteParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaEditParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaQueryParam;
import com.netlearning.framework.domain.course.result.TeachPlanMediaResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 22:29
 */
@Service
public class TeachPlanMediaServiceImpl implements TeachPlanMediaService {
    @Autowired
    private TeachPlanMediaMapper teachPlanMediaMapper;
    @Autowired
    private SequenceService sequenceService;

    @Override
    public CommonResult<Boolean> add(TeachPlanMediaAddParam request) {
        try {
            TeachPlanMedia record = new TeachPlanMedia();
            BeanCopyUtils.copyProperties(request,record);
            if (request.getTeachplanMediaId() == null){
                record.setTeachplanMediaId(sequenceService.nextValue(null));
            }
            teachPlanMediaMapper.insertSelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE002.code,ExceptionCode.CourseCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(TeachPlanMediaEditParam request) {
        try {
            TeachPlanMedia record = new TeachPlanMedia();
            BeanCopyUtils.copyProperties(request,record);
            teachPlanMediaMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE003.code,ExceptionCode.CourseCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(List<Long> teachplanMediaIds) {
        try {
            if (!CollectionUtils.isEmpty(teachplanMediaIds)){
                TeachPlanMediaExample example = new TeachPlanMediaExample();
                example.createCriteria().andTeachplanMediaIdIn(teachplanMediaIds);
                teachPlanMediaMapper.deleteByExample(example);
            }
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE004.code,ExceptionCode.CourseCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<CommonPageResult<TeachPlanMediaResult>> page(TeachPlanMediaQueryParam param, CommonPageInfo commonPageInfo) {
        TeachPlanMediaExample example = new TeachPlanMediaExample();
        TeachPlanMediaExample.Criteria criteria = example.createCriteria();
        if (param.getTeachplanMediaId() != null){
            criteria.andCourseIdEqualTo(param.getTeachplanMediaId());
        }
        if (param.getMediaId() != null){
            criteria.andMediaIdEqualTo(param.getMediaId());
        }
        if (!StringUtils.isEmpty(param.getMediaFileoriginalName())){
            criteria.andMediaFileoriginalNameLike("%"+param.getMediaFileoriginalName()+"%");
        }
        if (!StringUtils.isEmpty(param.getMediaUrl())){
            criteria.andMediaUrlEqualTo(param.getMediaUrl());
        }
        if (param.getCourseId() != null){
            criteria.andCourseIdEqualTo(param.getCourseId());
        }
        if (param.getTeachplanId() != null){
            criteria.andTeachplanIdEqualTo(param.getTeachplanId());
        }
        if (param.getRecordId() != null){
            criteria.andRecordIdEqualTo(param.getRecordId());
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<TeachPlanMedia> teachPlanMediaList = (Page<TeachPlanMedia>) teachPlanMediaMapper.selectByExample(example);
        List<TeachPlanMediaResult> teachPlanMediaResults = BeanCopyUtils.copy(teachPlanMediaList,TeachPlanMediaResult.class);
        CommonPageResult<TeachPlanMediaResult> pageResult = CommonPageResult.build(teachPlanMediaResults,commonPageInfo,teachPlanMediaList.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<List<TeachPlanMediaResult>> query(TeachPlanMediaQueryParam param) {
        TeachPlanMediaExample example = new TeachPlanMediaExample();
        TeachPlanMediaExample.Criteria criteria = example.createCriteria();
        if (param.getTeachplanMediaId() != null){
            criteria.andCourseIdEqualTo(param.getTeachplanMediaId());
        }
        if (param.getMediaId() != null){
            criteria.andMediaIdEqualTo(param.getMediaId());
        }
        if (!StringUtils.isEmpty(param.getMediaFileoriginalName())){
            criteria.andMediaFileoriginalNameLike("%"+param.getMediaFileoriginalName()+"%");
        }
        if (!StringUtils.isEmpty(param.getMediaUrl())){
            criteria.andMediaUrlEqualTo(param.getMediaUrl());
        }
        if (param.getCourseId() != null){
            criteria.andCourseIdEqualTo(param.getCourseId());
        }
        if (param.getTeachplanId() != null){
            criteria.andTeachplanIdEqualTo(param.getTeachplanId());
        }
        if (param.getRecordId() != null){
            criteria.andRecordIdEqualTo(param.getRecordId());
        }
        List<TeachPlanMedia> teachPlanMediaList = teachPlanMediaMapper.selectByExample(example);
        List<TeachPlanMediaResult> results  = BeanCopyUtils.copy(teachPlanMediaList,TeachPlanMediaResult.class);

        return CommonResult.success(results);
    }


}

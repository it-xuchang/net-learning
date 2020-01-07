package com.netlearning.course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.course.mapper.CourseQuziMapper;
import com.netlearning.course.service.CourseQuziService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.CourseQuzi;
import com.netlearning.framework.domain.course.CourseQuziExample;
import com.netlearning.framework.domain.course.param.CourseQuziAddParam;
import com.netlearning.framework.domain.course.param.CourseQuziDeleteParam;
import com.netlearning.framework.domain.course.param.CourseQuziEditParam;
import com.netlearning.framework.domain.course.param.CourseQuziQueryParam;
import com.netlearning.framework.domain.course.result.CourseQuziResult;
import com.netlearning.framework.em.CourseConstants;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/7 13:14
 */
@Service
public class CourseQuziServiceImpl implements CourseQuziService {
    @Autowired
    private CourseQuziMapper courseQuziMapper;
    @Autowired
    private SequenceService sequenceService;

    @Override
    public CommonResult<CommonPageResult<CourseQuziResult>> page(CommonPageInfo commonPageInfo, CourseQuziQueryParam param) {

        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        CourseQuziExample example = new CourseQuziExample();
        example.setOrderByClause("is_over_head ASC , create_time DESC");
        CourseQuziExample.Criteria criteria = example.createCriteria();
        if (param.getCourseId()!= null){
            criteria.andCourseIdEqualTo(param.getCourseId());
        }
        if (CourseConstants.IsShow.typeList().contains(param.getIsShow()) && !StringUtils.isEmpty(param.getIsShow())){
            criteria.andIsShowEqualTo(param.getIsShow());
        }
        if (CourseConstants.IsOverHead.typeList().contains(param.getIsOverHead()) && !StringUtils.isEmpty(param.getIsOverHead())){
            criteria.andIsOverHeadEqualTo(param.getIsOverHead());
        }
        if (param.getCourseQuziId() != null){
            criteria.andCourseQuziIdEqualTo(param.getCourseQuziId());
        }

        Page<CourseQuzi> page = (Page<CourseQuzi>) courseQuziMapper.selectByExample(example);
        List<CourseQuziResult> courseQuziResults = BeanCopyUtils.copy(page.getResult(),CourseQuziResult.class);
        CommonPageResult<CourseQuziResult> pageResult = CommonPageResult.build(courseQuziResults,commonPageInfo,page.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(CourseQuziAddParam param) {
        CourseQuzi record = new CourseQuzi();
        BeanCopyUtils.copyProperties(param,record);
        record.setCreateTime(new Date());
        record.setCourseQuziId(sequenceService.nextValue(null));
        if (StringUtils.isEmpty(param.getIsOverHead())){
            record.setIsOverHead(CourseConstants.IsOverHead.NON_OVER_HEAD.getCode());
        }
        if (StringUtils.isEmpty(param.getIsShow())){
            record.setIsShow(CourseConstants.IsShow.SHOW.getCode());
        }

        courseQuziMapper.insertSelective(record);
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> edit(CourseQuziEditParam param) {
        CourseQuzi record = new CourseQuzi();
        BeanCopyUtils.copyProperties(param,record);
        record.setUpdateTime(new Date());
        courseQuziMapper.updateByPrimaryKeySelective(record);
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> delete(CourseQuziDeleteParam param) {
        courseQuziMapper.deleteByPrimaryKey(param.getCourseQuziId());

        return CommonResult.success(true);
    }
}

package com.netlearning.course.service.impl;

import com.netlearning.course.mapper.TeachPlanMediaTencentMapper;
import com.netlearning.course.service.TeachPlanMediaTencenService;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.TeachPlanMediaTencent;
import com.netlearning.framework.domain.course.TeachPlanMediaTencentExample;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentDeleteParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentEditParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentQueryParam;
import com.netlearning.framework.domain.course.result.TeachPlanMediaTencentResult;
import com.netlearning.framework.snowflake.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/10 14:07
 */
@Service
public class TeachPlanMediaTencenServiceImpl implements TeachPlanMediaTencenService {
    @Autowired
    private TeachPlanMediaTencentMapper teachPlanMediaTencentMapper;
    @Autowired
    private SequenceService sequenceService;

    @Override
    public CommonResult<Boolean> add(TeachPlanMediaTencentAddParam param) {

        TeachPlanMediaTencent record = new TeachPlanMediaTencent();
        BeanCopyUtils.copyProperties(param,record);
        record.setTeachplanMediaTencentId(sequenceService.nextValue(null));
        teachPlanMediaTencentMapper.insertSelective(record);
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> edit(TeachPlanMediaTencentEditParam param) {
        TeachPlanMediaTencent record = new TeachPlanMediaTencent();
        BeanCopyUtils.copyProperties(param,record);
        teachPlanMediaTencentMapper.updateByPrimaryKeySelective(record);
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<List<TeachPlanMediaTencentResult>> query(TeachPlanMediaTencentQueryParam param) {

        TeachPlanMediaTencentExample example =  new TeachPlanMediaTencentExample();
        TeachPlanMediaTencentExample.Criteria criteria = example.createCriteria();
        if (param.getTeachplanMediaTencentId() != null){
            criteria.andTeachplanMediaIdEqualTo(param.getTeachplanMediaTencentId());
        }
        if (param.getTeachplanMediaId()!=null){
            criteria.andTeachplanMediaIdEqualTo(param.getTeachplanMediaId());
        }
        List<TeachPlanMediaTencent>  result = teachPlanMediaTencentMapper.selectByExample(example);
        List<TeachPlanMediaTencentResult> results = BeanCopyUtils.copy(result,TeachPlanMediaTencentResult.class);
        return CommonResult.success(results);
    }

    @Override
    public CommonResult<Boolean> delete(TeachPlanMediaTencentDeleteParam param) {

        teachPlanMediaTencentMapper.deleteByPrimaryKey(param.getTeachplanMediaTencentId());
        return CommonResult.success(true);
    }
}

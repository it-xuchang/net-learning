package com.netlearning.course.service.impl;

import com.netlearning.course.mapper.LearningTeachplanMapper;
import com.netlearning.course.service.LearningTeachplanService;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.LearningTeachplan;
import com.netlearning.framework.domain.course.LearningTeachplanExample;
import com.netlearning.framework.domain.course.param.LearningTeachplanAddParam;
import com.netlearning.framework.domain.course.param.LearningTeachplanEditParam;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/2/12 16:19
 */
@Service
public class LearningTeachplanServiceImpl  implements LearningTeachplanService {

    @Autowired
    private LearningTeachplanMapper learningTeachplanMapper;
    @Autowired
    private SequenceService sequenceService;

    @Override
    public CommonResult<Boolean> add(LearningTeachplanAddParam param) {

        if (param.getCourseId() == null ){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE012.code,ExceptionCode.CourseCode.CODE012.message);
        }
        if (param.getTeachplanId() == null) {
            return CommonResult.fail(ExceptionCode.CourseCode.CODE014.code,ExceptionCode.CourseCode.CODE014.message);
        }
        if (param.getUserId() == null){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE013.code,ExceptionCode.CourseCode.CODE013.message);
        }
        LearningTeachplanExample example = new LearningTeachplanExample();
        LearningTeachplanExample.Criteria criteria = example.createCriteria();
        criteria.andCourseIdEqualTo(param.getCourseId());
        criteria.andTeachplanIdEqualTo(param.getTeachplanId());
        criteria.andUserIdEqualTo(param.getUserId());

        List<LearningTeachplan> learningTeachplanList =  learningTeachplanMapper.selectByExample(example);
        Date now = new Date();
        if (CollectionUtils.isEmpty(learningTeachplanList)){
            LearningTeachplan record = new LearningTeachplan();
            BeanCopyUtils.copyProperties(param,record);
            record.setLearningTeachplanId(sequenceService.nextValue(null));
            record.setCreateTime(now);
            learningTeachplanMapper.insertSelective(record);
        }else {
            LearningTeachplan record = new LearningTeachplan();
            BeanCopyUtils.copyProperties(learningTeachplanList.get(0),record);

            record.setEndTime(now);
            learningTeachplanMapper.updateByPrimaryKeySelective(record);
        }

        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> edit(LearningTeachplanEditParam param) {
        return null;
    }
}

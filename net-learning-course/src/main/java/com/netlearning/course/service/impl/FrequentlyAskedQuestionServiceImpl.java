package com.netlearning.course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.course.mapper.FrequentlyAskedQuestionMapper;
import com.netlearning.course.service.FrequentlyAskedQuestionService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.FrequentlyAskedQuestion;
import com.netlearning.framework.domain.course.FrequentlyAskedQuestionExample;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionAddParam;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionDeleteParam;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionEditParam;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionQueryParam;
import com.netlearning.framework.domain.course.result.FrequentlyAskedQuestionResult;
import com.netlearning.framework.snowflake.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/7 16:52
 */
@Service
public class FrequentlyAskedQuestionServiceImpl implements FrequentlyAskedQuestionService {

    @Autowired
    private FrequentlyAskedQuestionMapper frequentlyAskedQuestionMapper;
    @Autowired
    private SequenceService sequenceService;

    @Override
    public CommonResult<CommonPageResult<FrequentlyAskedQuestionResult>> page(FrequentlyAskedQuestionQueryParam param, CommonPageInfo commonPageInfo) {
        FrequentlyAskedQuestionExample example = new FrequentlyAskedQuestionExample();
        if (param.getCourseId()!= null){
            example.createCriteria().andCourseIdEqualTo(param.getCourseId());
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<FrequentlyAskedQuestion> frequentlyAskedQuestionPage = (Page<FrequentlyAskedQuestion>) frequentlyAskedQuestionMapper.selectByExample(example);
        List<FrequentlyAskedQuestionResult> frequentlyAskedQuestionResults = BeanCopyUtils.copy(frequentlyAskedQuestionPage.getResult(),FrequentlyAskedQuestionResult.class);
        CommonPageResult<FrequentlyAskedQuestionResult> pageResult = CommonPageResult.build(frequentlyAskedQuestionResults,commonPageInfo,frequentlyAskedQuestionPage.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(FrequentlyAskedQuestionAddParam param) {
        FrequentlyAskedQuestion record = new FrequentlyAskedQuestion();
        BeanCopyUtils.copyProperties(param,record);
        record.setFrequentlyAskedQuestionId(sequenceService.nextValue(null));
        record.setCreateTime(new Date());
        frequentlyAskedQuestionMapper.insertSelective(record);
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> edit(FrequentlyAskedQuestionEditParam param) {
        FrequentlyAskedQuestion record = new FrequentlyAskedQuestion();
        BeanCopyUtils.copyProperties(param,record);
        record.setUpdateTime(new Date());
        frequentlyAskedQuestionMapper.updateByPrimaryKeySelective(record);
        return CommonResult.success(true);
    }

    @Override
    public CommonResult<Boolean> delete(FrequentlyAskedQuestionDeleteParam param) {
        frequentlyAskedQuestionMapper.deleteByPrimaryKey(param.getFrequentlyAskedQuestionId());
        return CommonResult.success(true);
    }


}

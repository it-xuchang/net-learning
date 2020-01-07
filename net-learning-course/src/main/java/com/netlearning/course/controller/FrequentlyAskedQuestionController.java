package com.netlearning.course.controller;

import com.netlearning.course.service.FrequentlyAskedQuestionService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionAddParam;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionDeleteParam;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionEditParam;
import com.netlearning.framework.domain.course.param.FrequentlyAskedQuestionQueryParam;
import com.netlearning.framework.domain.course.result.FrequentlyAskedQuestionResult;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/7 16:48
 */
@RestController
@RequestMapping("/frequently/asked/question")
public class FrequentlyAskedQuestionController {
    @Autowired
    private FrequentlyAskedQuestionService frequentlyAskedQuestionService;

    @GetMapping("/page")
    public CommonResult<CommonPageResult<FrequentlyAskedQuestionResult>> page(@RequestParam(value = "courseId",required = false) Long courseId,
                                                                              @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                                              @RequestParam(value = "pageSize",required = false) Integer pageSize){
        FrequentlyAskedQuestionQueryParam param = new FrequentlyAskedQuestionQueryParam();
        param.setCourseId(courseId);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);

        return frequentlyAskedQuestionService.page(param,commonPageInfo);
    }
    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody FrequentlyAskedQuestionAddParam param){

        return frequentlyAskedQuestionService.add(param);
    }

    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody FrequentlyAskedQuestionEditParam param){

        return frequentlyAskedQuestionService.edit(param);
    }
    @PostMapping("/delete")
    public CommonResult<Boolean> delete(@RequestBody FrequentlyAskedQuestionDeleteParam param){

        return frequentlyAskedQuestionService.delete(param);
    }
}

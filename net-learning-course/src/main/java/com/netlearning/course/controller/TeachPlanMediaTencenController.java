package com.netlearning.course.controller;

import com.netlearning.course.service.TeachPlanMediaTencenService;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentDeleteParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentEditParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaTencentQueryParam;
import com.netlearning.framework.domain.course.result.TeachPlanMediaTencentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/10 11:53
 */
@RestController
@RequestMapping("/techplan/media/tencent")
public class TeachPlanMediaTencenController {
    @Autowired
    private TeachPlanMediaTencenService teachPlanMediaTencenService;

    @GetMapping("/query")
    public CommonResult<List<TeachPlanMediaTencentResult>> query(@RequestParam(value = "teachplanMediaTencentId",required = false) Long teachplanMediaTencentId,
                                                                 @RequestParam(value = "teachplanMediaId",required = false) Long teachplanMediaId){

        TeachPlanMediaTencentQueryParam param = new TeachPlanMediaTencentQueryParam();
        param.setTeachplanMediaId(teachplanMediaId);
        param.setTeachplanMediaTencentId(teachplanMediaTencentId);
        return teachPlanMediaTencenService.query(param);
    }

    @RequestMapping("/add")
    public CommonResult<Boolean> add(TeachPlanMediaTencentAddParam param){

        return teachPlanMediaTencenService.add(param);
    }

    @RequestMapping("/edit")
    public CommonResult<Boolean> edit(TeachPlanMediaTencentEditParam param){

        return teachPlanMediaTencenService.edit(param);
    }
    @RequestMapping("/delete")
    public CommonResult<Boolean> delete(TeachPlanMediaTencentDeleteParam param){

        return teachPlanMediaTencenService.delete(param);
    }

}

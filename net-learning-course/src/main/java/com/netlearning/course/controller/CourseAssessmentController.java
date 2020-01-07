package com.netlearning.course.controller;

import com.netlearning.course.service.CourseAssessmentService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.CourseAssessmentAddParam;
import com.netlearning.framework.domain.course.param.CourseAssessmentDeleteParam;
import com.netlearning.framework.domain.course.param.CourseAssessmentEditParam;
import com.netlearning.framework.domain.course.param.CourseAssessmentQueryParam;
import com.netlearning.framework.domain.course.result.CourseAssessmentResult;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description: 课堂评价
 * @author: XUCHANG
 * @time: 2020/1/7 13:15
 */

@RequestMapping("/course/assessment")
@RestController
public class CourseAssessmentController {
    @Autowired
    private CourseAssessmentService courseAssessmentService;

    @GetMapping("/page")
    public CommonResult<CommonPageResult<CourseAssessmentResult>> page(@RequestParam(value = "courseId",required = false) Long courseId,
                                                                       @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                                       @RequestParam(value = "pageSize",required = false) Integer pageSize){
        CourseAssessmentQueryParam param = new CourseAssessmentQueryParam();
        param.setCourseId(courseId);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return courseAssessmentService.page(param,commonPageInfo);
    }
    @PostMapping("add")
    public CommonResult<Boolean> add(@RequestBody CourseAssessmentAddParam param){

        return courseAssessmentService.add(param);
    }
    @PostMapping("edit")
    public CommonResult<Boolean> edit(@RequestBody CourseAssessmentEditParam param){

        return courseAssessmentService.edit(param);
    }

    @PostMapping("delete")
    public CommonResult<Boolean> delete(@RequestBody CourseAssessmentDeleteParam param){

        return courseAssessmentService.delete(param.getCourseAssessmentId());
    }

}

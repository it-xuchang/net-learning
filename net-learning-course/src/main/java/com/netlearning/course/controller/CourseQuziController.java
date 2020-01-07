package com.netlearning.course.controller;

import com.netlearning.course.service.CourseQuziService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.CourseQuziAddParam;
import com.netlearning.framework.domain.course.param.CourseQuziDeleteParam;
import com.netlearning.framework.domain.course.param.CourseQuziEditParam;
import com.netlearning.framework.domain.course.param.CourseQuziQueryParam;
import com.netlearning.framework.domain.course.result.CourseQuziResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/7 13:14
 */
@RequestMapping("/course/quzi")
@RestController
public class CourseQuziController {
    @Autowired
    private CourseQuziService courseQuziService;

    @GetMapping("/page")
    public CommonResult<CommonPageResult<CourseQuziResult>> page(@RequestParam(value = "courseQuziId",required = false) Long courseQuziId,
                                                                 @RequestParam(value = "courseId",required = false) Long courseId,
                                                                 @RequestParam(value = "isShow",required = false) String isShow,
                                                                 @RequestParam(value = "isOverHead",required = false) String isOverHead,
                                                                 @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                                 @RequestParam(value = "pageSize",required = false) Integer pageSize){

        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        CourseQuziQueryParam param = new CourseQuziQueryParam();
        param.setIsShow(isShow);
        param.setIsOverHead(isOverHead);
        param.setCourseQuziId(courseQuziId);
        param.setCourseId(courseId);
        return courseQuziService.page(commonPageInfo,param);
    }

    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody CourseQuziAddParam param){

        return courseQuziService.add(param);
    }

    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody CourseQuziEditParam param){

        return courseQuziService.edit(param);
    }

    @PostMapping("delete")
    public CommonResult<Boolean> delete(@RequestBody CourseQuziDeleteParam param){

        return courseQuziService.delete(param);
    }


}

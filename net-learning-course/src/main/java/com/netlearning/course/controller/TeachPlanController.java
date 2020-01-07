package com.netlearning.course.controller;

import com.netlearning.course.service.TeachPlanService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.TeachPlanAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanEditParam;
import com.netlearning.framework.domain.course.param.TeachPlanQueryParam;
import com.netlearning.framework.domain.course.result.BaseCourseTeachPlanResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 20:49
 */
@RestController
@RequestMapping("/techplan")
public class TeachPlanController {
    @Autowired
    private TeachPlanService teachPlanService;

    @GetMapping("query")
    public CommonResult<List<BaseCourseTeachPlanResult>> query(@RequestParam(value = "teachplanId",required = false) Long teachplanId,
                                                         @RequestParam(value = "courseId",required = false)String courseId,
                                                         @RequestParam(value = "teachplanName",required = false)String teachplanName,
                                                         @RequestParam(value = "status",required = false)String status){
        TeachPlanQueryParam param = new TeachPlanQueryParam();
        param.setTeachplanId(teachplanId);
        param.setCourseId(courseId);
        param.setTeachplanName(teachplanName);
        param.setStatus(status);
        return teachPlanService.query(param);
    }

    @GetMapping("page")
    public CommonResult<CommonPageResult<BaseCourseTeachPlanResult>> page(@RequestParam(value = "teachplanId",required = false) Long teachplanId,
                                                                          @RequestParam(value = "courseId",required = false)String courseId,
                                                                          @RequestParam(value = "teachplanName",required = false)String teachplanName,
                                                                          @RequestParam(value = "status",required = false)String status,
                                                                          @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                                          @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        TeachPlanQueryParam param = new TeachPlanQueryParam();
        param.setTeachplanId(teachplanId);
        param.setCourseId(courseId);
        param.setTeachplanName(teachplanName);
        param.setStatus(status);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return teachPlanService.page(param,commonPageInfo);
    }

    @PostMapping("add")
    public CommonResult<Boolean> add(@RequestBody TeachPlanAddParam request){

        return teachPlanService.add(request);
    }

    @PostMapping("edit")
    public CommonResult<Boolean> edit(@RequestBody TeachPlanEditParam request){

        return teachPlanService.edit(request);
    }

    @PostMapping("delete")
    public CommonResult<Boolean> delete(List<Long> ids){

        return teachPlanService.delete(ids);
    }



}

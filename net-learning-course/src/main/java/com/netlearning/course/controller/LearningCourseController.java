package com.netlearning.course.controller;

import com.netlearning.course.service.LearningCourseService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.LearningCourseAddParam;
import com.netlearning.framework.domain.course.param.LearningCourseEditParam;
import com.netlearning.framework.domain.course.param.LearningCourseQueryParam;
import com.netlearning.framework.domain.course.result.UserLearningCourseResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 20:48
 */
@RestController
@RequestMapping("/learning/course")
public class LearningCourseController {
    @Autowired
    private LearningCourseService learningCourseService;

    @GetMapping("/query")
    public CommonResult<UserLearningCourseResult> query(@RequestParam(value = "userId",required = false) Long userId,
                                                             @RequestParam(value = "teacherId",required = false) Long teacherId,
                                                             @RequestParam(value = "learningId",required = false) Long learningId,
                                                             @RequestParam(value = "courseId",required = false) Long courseId,
                                                             @RequestParam(value = "createTime",required = false) String createTime,
                                                             @RequestParam(value = "endTime",required = false) String endTime){

        LearningCourseQueryParam param = new LearningCourseQueryParam();
        param.setCourseId(courseId);
        param.setCreateTime(createTime);
        param.setEndTime(endTime);
        param.setLearningId(learningId);
        param.setUserId(userId);
        param.setTeacherId(teacherId);
        return learningCourseService.query(param);
    }

    /**
     * 查询学生下的学习的课程
     * 该教师的课程--课程下学习的学生
     * 查询教师下的学生的学习课程
     */
    @GetMapping("/page")
    public CommonResult<CommonPageResult<UserLearningCourseResult>> page(@RequestParam(value = "userId",required = false) Long userId,
                                                                         @RequestParam(value = "teacherId",required = false) Long teacherId,
                                                                         @RequestParam(value = "learningId",required = false) Long learningId,
                                                                         @RequestParam(value = "courseId",required = false) Long courseId,
                                                                         @RequestParam(value = "createTime",required = false) String createTime,
                                                                         @RequestParam(value = "endTime",required = false) String endTime,
                                                                         @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                                         @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        LearningCourseQueryParam param = new LearningCourseQueryParam();
        param.setCourseId(courseId);
        param.setCreateTime(createTime);
        param.setEndTime(endTime);
        param.setLearningId(learningId);
        param.setUserId(userId);
        param.setTeacherId(teacherId);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return learningCourseService.page(param,commonPageInfo);
    }

    /**
     * 添加学习的课程
     * @param request
     * @return
     */
    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody LearningCourseAddParam request){
        return learningCourseService.add(request);
    }

    /**
     * 编辑学习的课程
     * @param request
     * @return
     */
    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody LearningCourseEditParam request){
        return learningCourseService.edit(request);
    }

    /**
     * 删除学习的课程
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    public CommonResult<Boolean> delete(@RequestBody List<Long> ids){
        return learningCourseService.delete(ids);
    }
}

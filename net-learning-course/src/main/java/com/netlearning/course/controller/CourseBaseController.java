package com.netlearning.course.controller;

import com.netlearning.course.service.CourseBaseService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.*;
import com.netlearning.framework.domain.course.result.CourseBaseDetailResult;
import com.netlearning.framework.domain.course.result.CourseBaseResult;
import com.netlearning.framework.domain.course.result.CourseRecommendationResult;
import com.netlearning.framework.domain.course.result.RecommendedCourseDirectionResult;
import com.netlearning.framework.domain.userAuth.Teacher;
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
@RequestMapping("/base/course")
@RestController
public class CourseBaseController {
    @Autowired
    private CourseBaseService courseBaseService;


    @GetMapping("/query")
    public CommonResult<List<CourseBaseResult>> query(@RequestParam(value = "courseId",required = false) Long courseId,
                                                      @RequestParam(value = "teacherId",required = false) Long teacherId,
                                                      @RequestParam(value = "courseName",required = false) String courseName,
                                                      @RequestParam(value = "users",required = false) String users,
                                                      @RequestParam(value = "category",required = false) String category){
        CourseBaseQueryParam param = new CourseBaseQueryParam();
        param.setCourseId(courseId);
        param.setTeacherId(teacherId);
        param.setCourseName(courseName);
        param.setUsers(users);
        param.setCategory(category);
        return courseBaseService.query(param);
    }

    @GetMapping("/page")
    public CommonResult<CommonPageResult<CourseBaseResult>>  page(@RequestParam(value = "courseId",required = false) Long courseId,
                                                                  @RequestParam(value = "teacherId",required = false) Long teacherId,
                                                                  @RequestParam(value = "courseName",required = false) String courseName,
                                                                  @RequestParam(value = "users",required = false) String users,
                                                                  @RequestParam(value = "category",required = false) String category,
                                                                  @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                                  @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        CourseBaseQueryParam param = new CourseBaseQueryParam();
        param.setCourseId(courseId);
        param.setTeacherId(teacherId);
        param.setCourseName(courseName);
        param.setUsers(users);
        param.setCategory(category);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);

        return courseBaseService.page(param,commonPageInfo);
    }
    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody CourseBaseAddParam request){

        return courseBaseService.add(request);
    }

    @PostMapping("/edit")
    public CommonResult<Boolean> edit(CourseBaseEditParam request){

        return courseBaseService.edit(request);
    }

    @PostMapping("/delete")
    public CommonResult<Boolean> delete(CourseBaseDeleteParam request){

        return courseBaseService.delete(request);
    }

    /**
     * 精品推荐
     * @param size 获取的个数 5个一列
     * @return
     */
    @GetMapping("/query/course/recommendation")
    public CommonResult<List<CourseRecommendationResult>> queryCourseRecommendation(@RequestParam(value = "size",required = false) Long size){

        return courseBaseService.queryCourseRecommendation(size);
    }
    /**
     * 课程方向
     */
    @GetMapping("/query/recommended/course/direction")
    public CommonResult<List<RecommendedCourseDirectionResult>> queryRecommendedCourseDirection(@RequestParam(value = "size",required = false) Long size,
                                                                                                @RequestParam(value = "categoryId",required = false) Long categoryId,
                                                                                                @RequestParam(value = "grade",required = false) String grade){

        return courseBaseService.queryRecommendedCourseDirection(size,categoryId,grade);
    }

    /**
     * 根据课程id查询课程信息--用户权限微服务调用
     * @param couresIds
     * @return
     */
    @GetMapping("/query/course")
    public CommonResult<List<CourseBaseResult>> queryByCouresIds(@RequestParam(value = "couresIds",required = false) List<Long> couresIds){
        CourseBaseQueryParam param = new CourseBaseQueryParam();
        param.setCouresIds(couresIds);
        return courseBaseService.query(param);
    }

    /**
     * 查询课程详情 课程信息包括 课程名称 课程难度 课程时长 课程评分 课程模式 适用人群 讲师 课程介绍
     * @param couresId
     * @return
     */
    @GetMapping("/query/course/detail")
    public CommonResult<CourseBaseDetailResult> queryCouresDetail(@RequestParam(value = "couresId",required = false) Long couresId){
        CourseBaseQueryParam param = new CourseBaseQueryParam();
        param.setCourseId(couresId);
        return courseBaseService.queryCouresDetail(param);
    }



}

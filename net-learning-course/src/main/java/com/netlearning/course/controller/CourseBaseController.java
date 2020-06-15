package com.netlearning.course.controller;

import com.netlearning.course.service.CourseBaseService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.*;
import com.netlearning.framework.domain.course.result.*;
import com.netlearning.framework.domain.userAuth.Teacher;
import com.netlearning.framework.em.CourseConstants;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.framework.utils.StringUtils;
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
                                                                  @RequestParam(value = "grade",required = false) String grade,
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
        param.setGrade(grade);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);

        return courseBaseService.page(param,commonPageInfo);
    }
    @PostMapping("/add")
    public CommonResult add(@RequestBody CourseBaseAddParam request){
        if (StringUtils.isEmpty(request.getCourseName())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE019.code,ExceptionCode.CourseCode.CODE019.message);
        }
        if (StringUtils.isEmpty(request.getCategory())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE020.code,ExceptionCode.CourseCode.CODE020.message);
        }
        if (StringUtils.isEmpty(request.getDescription())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE021.code,ExceptionCode.CourseCode.CODE021.message);
        }
        if (StringUtils.isEmpty(request.getStudymodel())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE022.code,ExceptionCode.CourseCode.CODE022.message);
        }
        if (StringUtils.isEmpty(request.getUsers())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE023.code,ExceptionCode.CourseCode.CODE023.message);
        }
        if (request.getTeacherId() == null){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE024.code,ExceptionCode.CourseCode.CODE024.message);
        }
        return courseBaseService.add(request);
    }

    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody CourseBaseEditParam request){
        if (StringUtils.isEmpty(request.getCourseName())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE019.code,ExceptionCode.CourseCode.CODE019.message);
        }
        if (StringUtils.isEmpty(request.getCategory())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE020.code,ExceptionCode.CourseCode.CODE020.message);
        }
        if (StringUtils.isEmpty(request.getDescription())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE021.code,ExceptionCode.CourseCode.CODE021.message);
        }
        if (StringUtils.isEmpty(request.getStudymodel())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE022.code,ExceptionCode.CourseCode.CODE022.message);
        }
        if (StringUtils.isEmpty(request.getUsers())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE023.code,ExceptionCode.CourseCode.CODE023.message);
        }
        if (request.getTeacherId() == null){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE024.code,ExceptionCode.CourseCode.CODE024.message);
        }
        return courseBaseService.edit(request);
    }

    @PostMapping("/change/status")
    public CommonResult<Boolean> changeStatus(@RequestBody CourseBaseEditParam request){
        if (request.getCourseId() == null){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE012.code,ExceptionCode.CourseCode.CODE012.message);
        }
        if (!CourseConstants.CourseType.courseTypeList().contains(request.getStatus())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE025.code,ExceptionCode.CourseCode.CODE025.message);
        }
        return courseBaseService.changeStatus(request);
    }



    @PostMapping("/delete")
    public CommonResult<Boolean> delete(@RequestBody CourseBaseDeleteParam request){

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

    /**
     * 课程详情页面的所有数据
     * @param couresId
     * @return
     */
    @GetMapping("/query/course/all/detail")
    public CommonResult<CourseAllDetailResult> queryCourseAllDetail(@RequestParam(value = "couresId",required = false) Long couresId,
                                                                    @RequestParam(value = "userId",required = false) Long userId){
        CourseAllDetailParam param = new CourseAllDetailParam();
        param.setCourseId(couresId);
        param.setUserId(userId);
        return courseBaseService.queryCourseAllDetail(param);
    }



}

package com.netlearning.course.controller;

import com.netlearning.course.service.CourseFavoriteService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.CourseFavoriteAddParam;
import com.netlearning.framework.domain.course.param.CourseFavoriteDeleteParam;
import com.netlearning.framework.domain.course.param.CourseFavoriteQueryParam;
import com.netlearning.framework.domain.course.result.CourseFavoriteResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/2/12 15:23
 */
@RestController
@RequestMapping("/course/favorite")
public class CourseFavoriteController {
    @Autowired
    private CourseFavoriteService courseFavoriteService;

    @PostMapping("/add")
    public CommonResult add(@RequestBody CourseFavoriteAddParam param){

        return courseFavoriteService.add(param);
    }

    @PostMapping("/delete")
    public CommonResult delete(@RequestBody CourseFavoriteDeleteParam param){

        return courseFavoriteService.delete(param);
    }

    @GetMapping("/page")
    public CommonResult<CommonPageResult<CourseFavoriteResult>>  page(@RequestParam(value = "courseId",required = false) Long courseId,
                                                                      @RequestParam(value = "userId",required = false) Long userId,
                                                                      @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                                      @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        CourseFavoriteQueryParam param = new CourseFavoriteQueryParam();
        param.setCourseId(courseId);
        param.setUserId(userId);

        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return courseFavoriteService.page(param,commonPageInfo);
    }

}

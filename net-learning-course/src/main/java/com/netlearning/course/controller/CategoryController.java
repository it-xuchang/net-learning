package com.netlearning.course.controller;

import com.netlearning.course.service.CategoryService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.CategoryAddParam;
import com.netlearning.framework.domain.course.param.CategoryDeleteParam;
import com.netlearning.framework.domain.course.param.CategoryEditParam;
import com.netlearning.framework.domain.course.param.CategoryQueryParam;
import com.netlearning.framework.domain.course.result.CategoryResult;
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
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/query")
    public CommonResult<List<CategoryResult>> query(@RequestParam(value = "categoryId",required = false) Long categoryId,
                                                    @RequestParam(value = "categoryName",required = false) String categoryName,
                                                    @RequestParam(value = "isShow",required = false) String isShow){
        CategoryQueryParam param = new CategoryQueryParam();
        param.setCategoryId(categoryId);
        param.setCategoryName(categoryName);
        param.setIsShow(isShow);
        return categoryService.query(param);
    }

    @GetMapping("/page")
    public CommonResult<CommonPageResult<CategoryResult>>  page(@RequestParam(value = "categoryId",required = false) Long categoryId,
                                                                @RequestParam(value = "categoryName",required = false) String categoryName,
                                                                @RequestParam(value = "isShow",required = false) String isShow,
                                                                @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                                @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        CategoryQueryParam param = new CategoryQueryParam();
        param.setCategoryId(categoryId);
        param.setCategoryName(categoryName);
        param.setIsShow(isShow);

        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);

        return categoryService.page(param,commonPageInfo);
    }
    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody CategoryAddParam request){
        if (StringUtils.isEmpty(request.getCategoryName())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE017.code,ExceptionCode.CourseCode.CODE017.message);
        }
        if (StringUtils.isEmpty(request.getLabel())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE018.code,ExceptionCode.CourseCode.CODE018.message);
        }
        return categoryService.add(request);
    }

    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody CategoryEditParam request){
        if (request.getCategoryId() == null ){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE016.code,ExceptionCode.CourseCode.CODE016.message);
        }
        if (StringUtils.isEmpty(request.getCategoryName())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE017.code,ExceptionCode.CourseCode.CODE017.message);
        }
        if (StringUtils.isEmpty(request.getLabel())){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE018.code,ExceptionCode.CourseCode.CODE018.message);
        }
        return categoryService.edit(request);
    }

    @PostMapping("/delete")
    public CommonResult<Boolean> delete(@RequestBody List<Long> categoryIds){

        return categoryService.delete(categoryIds);
    }
}

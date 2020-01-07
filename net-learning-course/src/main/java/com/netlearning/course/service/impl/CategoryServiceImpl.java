package com.netlearning.course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.course.mapper.CategoryMapper;
import com.netlearning.course.service.CategoryService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.Category;
import com.netlearning.framework.domain.course.CategoryExample;
import com.netlearning.framework.domain.course.param.CategoryAddParam;
import com.netlearning.framework.domain.course.param.CategoryDeleteParam;
import com.netlearning.framework.domain.course.param.CategoryEditParam;
import com.netlearning.framework.domain.course.param.CategoryQueryParam;
import com.netlearning.framework.domain.course.result.CategoryResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 20:58
 */
@Service
public class CategoryServiceImpl  implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private SequenceService sequenceService;
    @Override
    public CommonResult<List<CategoryResult>> query(CategoryQueryParam param) {
        return null;
    }

    @Override
    public CommonResult<CommonPageResult<CategoryResult>> page(CategoryQueryParam param, CommonPageInfo commonPageInfo) {
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        CategoryExample example = new CategoryExample();

        Page<Category> page = (Page<Category>) categoryMapper.selectByExample(example);
        List<CategoryResult> categoryResults = BeanCopyUtils.copy(page.getResult(),CategoryResult.class);
        CommonPageResult<CategoryResult> pageResult = CommonPageResult.build(categoryResults,commonPageInfo,page.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(CategoryAddParam request) {
        Category record = new Category();
        BeanCopyUtils.copyProperties(request,record);
        record.setCategoryId(sequenceService.nextValue(null));
        try {
            categoryMapper.insertSelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE002.code,ExceptionCode.CourseCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(CategoryEditParam request) {
        try {
            Category record = new Category();
            BeanCopyUtils.copyProperties(request,record);
            categoryMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE002.code,ExceptionCode.CourseCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(List<Long> categoryIds) {
        try {
            if (!CollectionUtils.isEmpty(categoryIds)){
                CategoryExample example = new CategoryExample();
                example.createCriteria().andCategoryIdIn(categoryIds);
                categoryMapper.deleteByExample(example);
            }
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE004.code,ExceptionCode.CourseCode.CODE004.message);
        }
    }
}

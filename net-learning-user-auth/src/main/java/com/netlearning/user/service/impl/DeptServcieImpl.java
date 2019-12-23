package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.DateUtils;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.mapper.DeptMapper;
import com.netlearning.framework.domain.userAuth.Dept;
import com.netlearning.framework.domain.userAuth.DeptExample;
import com.netlearning.framework.domain.userAuth.DeptParam;
import com.netlearning.user.service.DeptServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:41
 */
@Service
public class DeptServcieImpl implements DeptServcie {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    protected SequenceService sequenceService;

    @Override
    public CommonResult<List<Dept>> query(DeptParam dept) {
        DeptExample example = new DeptExample();
        example.setOrderByClause("CREATE_TIME desc");
        DeptExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(dept.getStartCreateTime()) && !StringUtils.isEmpty(dept.getEndCreateTime())){
            criteria.andCreateTimeBetween(DateUtils.parseDate(dept.getStartCreateTime()),DateUtils.parseDate(dept.getEndCreateTime()));
        }
        if (dept.getDeptId() != null){
            criteria.andDeptIdEqualTo(dept.getDeptId());
        }
        if (!StringUtils.isEmpty(dept.getDeptName())){
            criteria.andDeptNameLike("%"+dept.getDeptName()+"%");
        }
        if (dept.getParentId() != null){
            criteria.andParentIdEqualTo(dept.getParentId());
        }
        List<Dept> page = deptMapper.selectByExample(example);

        return CommonResult.success(page);
    }

    @Override
    public CommonResult<CommonPageResult<Dept>> page(DeptParam dept, CommonPageInfo commonPageInfo) {

        DeptExample example = new DeptExample();
        example.setOrderByClause("CREATE_TIME desc");
        DeptExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(dept.getStartCreateTime()) && !StringUtils.isEmpty(dept.getEndCreateTime())){
            criteria.andCreateTimeBetween(DateUtils.parseDate(dept.getStartCreateTime()),DateUtils.parseDate(dept.getEndCreateTime()));
        }
        if (dept.getDeptId() != null){
            criteria.andDeptIdEqualTo(dept.getDeptId());
        }
        if (!StringUtils.isEmpty(dept.getDeptName())){
            criteria.andDeptNameLike("%"+dept.getDeptName()+"%");
        }
        if (dept.getParentId() != null){
            criteria.andParentIdEqualTo(dept.getParentId());
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<Dept> page = (Page<Dept>) deptMapper.selectByExample(example);
        CommonPageResult pageResult = CommonPageResult.build(page.getResult(),commonPageInfo,page.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(Dept dept) {
        try {
            dept.setDeptId(sequenceService.nextValue(null));
            dept.setCreateTime(new Date());
            deptMapper.insertSelective(dept);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE002.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(Dept dept) {
        try {
            Optional<Dept> result = Optional.ofNullable(deptMapper.selectByPrimaryKey(dept.getDeptId()));
            if (result.isPresent()){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE008.code,ExceptionCode.UserAuthCode.CODE008.message);
            }
            dept.setModifyTime(new Date());
            deptMapper.updateByPrimaryKeySelective(dept);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(Long deptId) {
        try {
            deptMapper.deleteByPrimaryKey(deptId);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }
}
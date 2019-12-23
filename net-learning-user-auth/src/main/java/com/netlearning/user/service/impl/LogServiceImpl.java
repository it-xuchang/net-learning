package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.DateUtils;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.mapper.LogMapper;
import com.netlearning.framework.domain.userAuth.Log;
import com.netlearning.framework.domain.userAuth.LogExample;
import com.netlearning.framework.domain.userAuth.LogParam;
import com.netlearning.framework.domain.userAuth.LogWithBLOBs;
import com.netlearning.user.service.LogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/21 9:58
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public CommonResult<List<Log>> query(LogParam logParam) {
        LogExample example = new LogExample();
        LogExample.Criteria criteria = example.createCriteria();
        if (logParam.getId() != null){
            criteria.andIdEqualTo(logParam.getId());
        }
        if (logParam.getTime() != null){
            criteria.andTimeEqualTo(logParam.getTime());
        }
        if (!StringUtils.isEmpty(logParam.getUsername())){
            criteria.andUsernameEqualTo(logParam.getUsername());
        }
        if (!StringUtils.isEmpty(logParam.getIp())){
            criteria.andIpEqualTo(logParam.getIp());
        }
        if (!StringUtils.isEmpty(logParam.getLocation())){
            criteria.andLocationEqualTo(logParam.getLocation());
        }
        if (!StringUtils.isEmpty(logParam.getStartCreateTime()) && !StringUtils.isEmpty(logParam.getEndCreateTime())){
            criteria.andCreateTimeBetween(DateUtils.parseDate(logParam.getStartCreateTime()),DateUtils.parseDate(logParam.getEndCreateTime()));
        }

        List<Log> result = logMapper.selectByExample(example);
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<CommonPageResult<Log>> page(LogParam logParam, CommonPageInfo commonPageInfo) {
        LogExample example = new LogExample();
        LogExample.Criteria criteria = example.createCriteria();
        if (logParam.getId() != null){
            criteria.andIdEqualTo(logParam.getId());
        }
        if (logParam.getTime() != null){
            criteria.andTimeEqualTo(logParam.getTime());
        }
        if (!StringUtils.isEmpty(logParam.getUsername())){
            criteria.andUsernameEqualTo(logParam.getUsername());
        }
        if (!StringUtils.isEmpty(logParam.getIp())){
            criteria.andIpEqualTo(logParam.getIp());
        }
        if (!StringUtils.isEmpty(logParam.getLocation())){
            criteria.andLocationEqualTo(logParam.getLocation());
        }
        if (!StringUtils.isEmpty(logParam.getStartCreateTime()) && !StringUtils.isEmpty(logParam.getEndCreateTime())){
            criteria.andCreateTimeBetween(DateUtils.parseDate(logParam.getStartCreateTime()),DateUtils.parseDate(logParam.getEndCreateTime()));
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<Log> result = (Page<Log>) logMapper.selectByExample(example);
        CommonPageResult<Log> pageResult  = CommonPageResult.build(result.getResult(),commonPageInfo,result.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(Log log) {
        try {
            LogWithBLOBs record = new LogWithBLOBs();
            BeanUtils.copyProperties(log,record);
            log.setCreateTime(new Date());
            logMapper.insertSelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(Log log) {
        try {
            LogWithBLOBs record = new LogWithBLOBs();
            BeanUtils.copyProperties(log,record);
            logMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(Long id) {
        try {
            logMapper.deleteByPrimaryKey(id);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }
}

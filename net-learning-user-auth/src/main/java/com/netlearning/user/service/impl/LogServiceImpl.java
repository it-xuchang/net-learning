package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.param.LogAddParam;
import com.netlearning.framework.domain.userAuth.param.LogDeleteParam;
import com.netlearning.framework.domain.userAuth.param.LogEditParam;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
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
    @Autowired
    private SequenceService sequenceService;
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
    public CommonResult<Boolean> add(LogAddParam param) {
        try {
            LogWithBLOBs record = new LogWithBLOBs();
            BeanUtils.copyProperties(param,record);
            record.setId(sequenceService.nextValue(null));
            record.setCreateTime(new Date());
            logMapper.insertSelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(LogEditParam param) {
        try {
            LogWithBLOBs record = new LogWithBLOBs();
            BeanUtils.copyProperties(param,record);
            logMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(LogDeleteParam param) {
        try {
            LogExample example = new LogExample();
            LogExample.Criteria criteria = example.createCriteria();
            if (CollectionUtils.isEmpty(param.getIds())){
                criteria.andIdIn(param.getIds());
            }
            logMapper.deleteByExample(example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }
}

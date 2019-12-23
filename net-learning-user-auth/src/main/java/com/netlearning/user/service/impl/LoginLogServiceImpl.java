package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.DateUtils;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.mapper.LoginLogMapper;
import com.netlearning.framework.domain.userAuth.LoginLog;
import com.netlearning.framework.domain.userAuth.LoginLogExample;
import com.netlearning.framework.domain.userAuth.LoginLogParam;
import com.netlearning.user.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/21 9:55
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public CommonResult<List<LoginLog>> query(LoginLogParam logParam) {
        LoginLogExample example = new LoginLogExample();
        LoginLogExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(logParam.getUsername())){
            criteria.andUsernameEqualTo(logParam.getUsername());
        }
        if (!StringUtils.isEmpty(logParam.getLocation())){
            criteria.andLocationEqualTo(logParam.getLocation());
        }
        if (!StringUtils.isEmpty(logParam.getIp())){
            criteria.andIpEqualTo(logParam.getIp());
        }
        if (!StringUtils.isEmpty(logParam.getStartLoginTime()) && !StringUtils.isEmpty(logParam.getEndLoginTime())){
            criteria.andLoginTimeBetween(DateUtils.parseDate(logParam.getStartLoginTime()),DateUtils.parseDate(logParam.getEndLoginTime()));
        }
        List<LoginLog> result = loginLogMapper.selectByExample(example);
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<CommonPageResult<LoginLog>> page(LoginLogParam logParam, CommonPageInfo commonPageInfo) {
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        LoginLogExample example = new LoginLogExample();
        LoginLogExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(logParam.getUsername())){
            criteria.andUsernameEqualTo(logParam.getUsername());
        }
        if (!StringUtils.isEmpty(logParam.getLocation())){
            criteria.andLocationEqualTo(logParam.getLocation());
        }
        if (!StringUtils.isEmpty(logParam.getIp())){
            criteria.andIpEqualTo(logParam.getIp());
        }
        if (!StringUtils.isEmpty(logParam.getStartLoginTime()) && !StringUtils.isEmpty(logParam.getEndLoginTime())){
            criteria.andLoginTimeBetween(DateUtils.parseDate(logParam.getStartLoginTime()),DateUtils.parseDate(logParam.getEndLoginTime()));
        }
        Page<LoginLog> result = (Page<LoginLog>) loginLogMapper.selectByExample(example);
        CommonPageResult<LoginLog> pageResult = CommonPageResult.build(result.getResult(),commonPageInfo,result.getTotal());
        return  CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(LoginLog log) {
        try {
            log.setLoginTime(new Date());
            loginLogMapper.insertSelective(log);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE002.code,ExceptionCode.UserAuthCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(LoginLog log) {
        try {
            LoginLogExample example = new LoginLogExample();
            LoginLogExample.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(log.getUsername())){
                criteria.andUsernameEqualTo(log.getUsername());
            }
            if (!StringUtils.isEmpty(log.getLocation())){
                criteria.andLocationEqualTo(log.getLocation());
            }
            if (!StringUtils.isEmpty(log.getIp())){
                criteria.andIpEqualTo(log.getIp());
            }
            loginLogMapper.updateByExampleSelective(log,example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(LoginLog log) {
        try {
            LoginLogExample example = new LoginLogExample();
            LoginLogExample.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(log.getUsername())){
                criteria.andUsernameEqualTo(log.getUsername());
            }
            if (!StringUtils.isEmpty(log.getLocation())){
                criteria.andLocationEqualTo(log.getLocation());
            }
            if (!StringUtils.isEmpty(log.getIp())){
                criteria.andIpEqualTo(log.getIp());
            }
            loginLogMapper.deleteByExample(example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }
}

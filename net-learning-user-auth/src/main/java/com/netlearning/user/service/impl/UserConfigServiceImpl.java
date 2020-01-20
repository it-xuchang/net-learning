package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.userAuth.param.UserConfigAddParam;
import com.netlearning.framework.domain.userAuth.param.UserConfigDeleteParam;
import com.netlearning.framework.domain.userAuth.param.UserConfigEditParam;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.mapper.UserConfigMapper;
import com.netlearning.framework.domain.userAuth.UserConfig;
import com.netlearning.framework.domain.userAuth.UserConfigExample;
import com.netlearning.framework.domain.userAuth.UserConfigParam;
import com.netlearning.user.service.UserConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:26
 */
@Service
public class UserConfigServiceImpl implements UserConfigService {
    @Autowired
    private UserConfigMapper userConfigMapper;
    @Autowired
    private SequenceService sequenceService;


    @Override
    public CommonResult<List<UserConfig>> query(UserConfigParam userConfigParam) {

        UserConfigExample example = new UserConfigExample();
        UserConfigExample.Criteria criteria = example.createCriteria();

        if (userConfigParam.getUserId() != null){
            criteria.andUserIdEqualTo(userConfigParam.getUserId());
        }
        if (!StringUtils.isEmpty(userConfigParam.getColor())){
            criteria.andColorEqualTo(userConfigParam.getColor());
        }
        if (!StringUtils.isEmpty(userConfigParam.getFixHeader())){
            criteria.andFixHeaderEqualTo(userConfigParam.getFixHeader());
        }
        if (!StringUtils.isEmpty(userConfigParam.getFixSiderbar())){
            criteria.andFixSiderbarEqualTo(userConfigParam.getFixSiderbar());
        }
        if (!StringUtils.isEmpty(userConfigParam.getLayout())){
            criteria.andLayoutEqualTo(userConfigParam.getLayout());
        }
        if (!StringUtils.isEmpty(userConfigParam.getMultiPage())){
            criteria.andMultiPageEqualTo(userConfigParam.getMultiPage());
        }
        if (!StringUtils.isEmpty(userConfigParam.getTheme())){
            criteria.andThemeEqualTo(userConfigParam.getTheme());
        }
        List<UserConfig> result = userConfigMapper.selectByExample(example);
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<CommonPageResult<UserConfig>> page(UserConfigParam userConfigParam, CommonPageInfo commonPageInfo) {
        UserConfigExample example = new UserConfigExample();
        UserConfigExample.Criteria criteria = example.createCriteria();

        if (userConfigParam.getUserId() != null){
            criteria.andUserIdEqualTo(userConfigParam.getUserId());
        }
        if (!StringUtils.isEmpty(userConfigParam.getColor())){
            criteria.andColorEqualTo(userConfigParam.getColor());
        }
        if (!StringUtils.isEmpty(userConfigParam.getFixHeader())){
            criteria.andFixHeaderEqualTo(userConfigParam.getFixHeader());
        }
        if (!StringUtils.isEmpty(userConfigParam.getFixSiderbar())){
            criteria.andFixSiderbarEqualTo(userConfigParam.getFixSiderbar());
        }
        if (!StringUtils.isEmpty(userConfigParam.getLayout())){
            criteria.andLayoutEqualTo(userConfigParam.getLayout());
        }
        if (!StringUtils.isEmpty(userConfigParam.getMultiPage())){
            criteria.andMultiPageEqualTo(userConfigParam.getMultiPage());
        }
        if (!StringUtils.isEmpty(userConfigParam.getTheme())){
            criteria.andThemeEqualTo(userConfigParam.getTheme());
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<UserConfig> result = (Page<UserConfig>) userConfigMapper.selectByExample(example);
        CommonPageResult<UserConfig> pageResult = CommonPageResult.build(result.getResult(),commonPageInfo,result.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(UserConfigAddParam userConfig) {
        try {
            UserConfig record = new UserConfig();
            BeanCopyUtils.copyProperties(userConfig,record);
            userConfigMapper.insertSelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE002.code,ExceptionCode.UserAuthCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(UserConfigEditParam userConfig) {
        try {
            UserConfig record = new UserConfig();
            BeanCopyUtils.copyProperties(userConfig,record);
            userConfigMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(UserConfigDeleteParam param) {
        try {
            if (CollectionUtils.isEmpty(param.getUserIds())){
                return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
            }
            UserConfigExample example = new UserConfigExample();
            UserConfigExample.Criteria criteria =example.createCriteria();
            if (CollectionUtils.isEmpty(param.getUserIds())){
                criteria.andUserIdIn(param.getUserIds());
            }
            userConfigMapper.deleteByExample(example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }
}

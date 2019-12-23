package com.netlearning.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.user.mapper.DictMapper;
import com.netlearning.framework.domain.userAuth.Dict;
import com.netlearning.framework.domain.userAuth.DictExample;
import com.netlearning.framework.domain.userAuth.DictParam;
import com.netlearning.user.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:33
 */
@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;
    @Autowired
    private SequenceService sequenceService;
    @Override
    public CommonResult<List<Dict>> query(DictParam dictParam) {

        DictExample example = new DictExample();
        DictExample.Criteria criteria = example.createCriteria();
        if (dictParam.getDictId() != null){
            criteria.andDictIdEqualTo(dictParam.getDictId());
        }
        if (dictParam.getKey() != null){
            criteria.andKeyyEqualTo(dictParam.getKey());
        }
        if (!StringUtils.isEmpty(dictParam.getValue())){
            criteria.andValueeEqualTo(dictParam.getValue());
        }
        if (!StringUtils.isEmpty(dictParam.getFieldName())){
            criteria.andFieldNameLike("%"+dictParam.getFieldName()+"%");
        }
        if (!StringUtils.isEmpty(dictParam.getTableName())){
            criteria.andTableNameLike("%"+dictParam.getTableName()+"%");
        }
        List<Dict> result = dictMapper.selectByExample(example);
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<CommonPageResult<Dict>> page(DictParam dictParam, CommonPageInfo commonPageInfo) {

        DictExample example = new DictExample();
        DictExample.Criteria criteria = example.createCriteria();
        if (dictParam.getDictId() != null){
            criteria.andDictIdEqualTo(dictParam.getDictId());
        }
        if (dictParam.getKey() != null){
            criteria.andKeyyEqualTo(dictParam.getKey());
        }
        if (!StringUtils.isEmpty(dictParam.getValue())){
            criteria.andValueeEqualTo(dictParam.getValue());
        }
        if (!StringUtils.isEmpty(dictParam.getFieldName())){
            criteria.andFieldNameLike("%"+dictParam.getFieldName()+"%");
        }
        if (!StringUtils.isEmpty(dictParam.getTableName())){
            criteria.andTableNameLike("%"+dictParam.getTableName()+"%");
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());

        Page<Dict> page = (Page<Dict>) dictMapper.selectByExample(example);
        CommonPageResult<Dict> pageResult = CommonPageResult.build(page.getResult(),commonPageInfo,page.getTotal());
        return CommonResult.success(pageResult);
    }

    @Override
    public CommonResult<Boolean> add(Dict dict) {
        try {
            dict.setDictId(sequenceService.nextValue(null));
            dictMapper.insertSelective(dict);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE002.code,ExceptionCode.UserAuthCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(Dict dict) {
        try {
            dictMapper.updateByPrimaryKeySelective(dict);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE003.code,ExceptionCode.UserAuthCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(Long dictId) {
        try {
            dictMapper.deleteByPrimaryKey(dictId);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE004.code,ExceptionCode.UserAuthCode.CODE004.message);
        }
    }
}

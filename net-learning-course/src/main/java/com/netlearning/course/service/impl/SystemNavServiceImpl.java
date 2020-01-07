package com.netlearning.course.service.impl;

import com.netlearning.course.mapper.SystemNavMapper;
import com.netlearning.course.service.SystemNavService;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.SystemNav;
import com.netlearning.framework.domain.course.SystemNavExample;
import com.netlearning.framework.domain.course.param.SystemNavAddParam;
import com.netlearning.framework.domain.course.param.SystemNavEditParam;
import com.netlearning.framework.domain.course.result.SystemNavResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/6 10:57
 */
@Service
public class SystemNavServiceImpl implements SystemNavService {
    @Autowired
    private SystemNavMapper systemNavMapper;
    @Autowired
    private SequenceService sequenceService;

    @Override
    public CommonResult<Boolean> add(SystemNavAddParam requset) {
        SystemNav record = new SystemNav();
        BeanCopyUtils.copyProperties(requset,record);
        record.setSystemNavId(sequenceService.nextValue(null));
        try {
            systemNavMapper.insertSelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE002.code,ExceptionCode.CourseCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(SystemNavEditParam requset) {
        SystemNav record = new SystemNav();
        BeanCopyUtils.copyProperties(requset,record);
        try {
            systemNavMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE003.code,ExceptionCode.CourseCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(Long systemNavId) {
        try {
            systemNavMapper.deleteByPrimaryKey(systemNavId);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE004.code,ExceptionCode.CourseCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<List<SystemNavResult>> query() {
        SystemNavExample example = new SystemNavExample();
        List<Long> fromSystemIds = new ArrayList<>();
        List<SystemNav> systemNavList =  systemNavMapper.selectByExample(example);
        for (SystemNav systemNav : systemNavList){
            if (!fromSystemIds.contains(systemNav.getFromSystemId())){
                fromSystemIds.add(systemNav.getFromSystemId());
            }
        }
        //调用文件系统的微服务获取文件的url
        Map<Long,Object> recordMap = new HashMap<>();
        List<SystemNavResult> results = new ArrayList<>();
        for (SystemNav systemNav : systemNavList){
            SystemNavResult navResult = new SystemNavResult();
            BeanCopyUtils.copyProperties(systemNav,navResult);
            if (recordMap.containsKey(systemNav.getFromSystemId())){
                //获取fastdfs的文件详情
            }
            results.add(navResult);
        }
        return CommonResult.success(results);
    }
}

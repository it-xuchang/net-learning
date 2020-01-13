package com.netlearning.fss.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.fss.FileRecord;
import com.netlearning.framework.domain.fss.FileRecordExample;
import com.netlearning.framework.domain.fss.FileRecordResources;
import com.netlearning.framework.domain.fss.FileRecordResourcesExample;
import com.netlearning.framework.domain.fss.param.FileRecordResourcesQueryParam;
import com.netlearning.framework.domain.fss.result.FileRecordResourcesResult;
import com.netlearning.framework.domain.fss.result.FileRecordResult;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.fss.mapper.FileRecordMapper;
import com.netlearning.fss.mapper.FileRecordResourcesMapper;
import com.netlearning.fss.service.FileRecordResourcesService;
import com.sun.org.apache.regexp.internal.RE;
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
 * @time: 2019/12/28 23:21
 */
@Service
public class FileRecordResourcesServiceImpl implements FileRecordResourcesService {
    @Autowired
    private FileRecordResourcesMapper fileRecordResourcesMapper;
    @Autowired
    private FileRecordMapper fileRecordMapper;
    @Override
    public CommonResult query(FileRecordResourcesQueryParam param) {
        FileRecordResourcesExample example = new FileRecordResourcesExample();
        FileRecordResourcesExample.Criteria criteria = example.createCriteria();
        if (param.getRecordId() != null){
            criteria.andRecordIdEqualTo(param.getRecordId());
        }
        if (param.getRecordResourcesId() != null){
            criteria.andRecordResourcesIdEqualTo(param.getRecordResourcesId());
        }
        if (param.getFromSystemId() != null){
            criteria.andFromSystemIdEqualTo(param.getFromSystemId());
        }
        List<FileRecordResources> fileRecordResourcesList = fileRecordResourcesMapper.selectByExample(example);
        List<Long> recordIds = new ArrayList<>();
        for (FileRecordResources recordResource : fileRecordResourcesList){
            if (!recordIds.contains(recordResource.getRecordId())){
                recordIds.add(recordResource.getRecordId());
            }
        }
        Map<Long, FileRecordResult> fileRecordResultMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(recordIds)){
            FileRecordExample fileRecordExample = new FileRecordExample();
            FileRecordExample.Criteria fileRecordExampleCriteria = fileRecordExample.createCriteria();
            fileRecordExampleCriteria.andRecordIdIn(recordIds);
            List<FileRecord> fileRecordList = fileRecordMapper.selectByExample(fileRecordExample);
            for (FileRecord fileRecord : fileRecordList){
                FileRecordResult fileRecordResult = new FileRecordResult();
                BeanCopyUtils.copyProperties(fileRecord,fileRecordResult);
                fileRecordResultMap.put(fileRecord.getRecordId(),fileRecordResult);
            }
        }
        List<FileRecordResourcesResult> recordResourcesResults = new ArrayList<>();
        for (FileRecordResources recordResource : fileRecordResourcesList){
            FileRecordResourcesResult fileRecordResourcesResult = new FileRecordResourcesResult();
            BeanCopyUtils.copyProperties(recordResource,fileRecordResourcesResult);
            if (fileRecordResultMap.containsKey(recordResource.getRecordId())){
                fileRecordResourcesResult.setRecord(fileRecordResultMap.get(recordResource.getRecordId()));
            }
            recordResourcesResults.add(fileRecordResourcesResult);
        }
        return CommonResult.success(recordResourcesResults);
    }

    @Override
    public CommonResult page(FileRecordResourcesQueryParam param, CommonPageInfo commonPageInfo) {
        FileRecordResourcesExample example = new FileRecordResourcesExample();
        FileRecordResourcesExample.Criteria criteria = example.createCriteria();
        if (param.getRecordId() != null){
            criteria.andRecordIdEqualTo(param.getRecordId());
        }
        if (param.getRecordResourcesId() != null){
            criteria.andRecordResourcesIdEqualTo(param.getRecordResourcesId());
        }
        if (param.getFromSystemId() != null){
            criteria.andFromSystemIdEqualTo(param.getFromSystemId());
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<FileRecordResources> fileRecordResourcesPage = (Page<FileRecordResources>) fileRecordResourcesMapper.selectByExample(example);
        List<Long> recordIds = new ArrayList<>();
        for (FileRecordResources recordResource : fileRecordResourcesPage.getResult()){
            if (!recordIds.contains(recordResource.getRecordId())){
                recordIds.add(recordResource.getRecordId());
            }
        }
        Map<Long, FileRecordResult> fileRecordResultMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(recordIds)){
            FileRecordExample fileRecordExample = new FileRecordExample();
            FileRecordExample.Criteria fileRecordExampleCriteria = fileRecordExample.createCriteria();
            fileRecordExampleCriteria.andRecordIdIn(recordIds);
            List<FileRecord> fileRecordList = fileRecordMapper.selectByExample(fileRecordExample);
            for (FileRecord fileRecord : fileRecordList){
                FileRecordResult fileRecordResult = new FileRecordResult();
                BeanCopyUtils.copyProperties(fileRecord,fileRecordResult);
                fileRecordResultMap.put(fileRecord.getRecordId(),fileRecordResult);
            }
        }
        List<FileRecordResourcesResult> recordResourcesResults = new ArrayList<>();
        for (FileRecordResources recordResource : fileRecordResourcesPage.getResult()){
            FileRecordResourcesResult fileRecordResourcesResult = new FileRecordResourcesResult();
            BeanCopyUtils.copyProperties(recordResource,fileRecordResourcesResult);
            if (fileRecordResultMap.containsKey(recordResource.getRecordId())){
                fileRecordResourcesResult.setRecord(fileRecordResultMap.get(recordResource.getRecordId()));
            }
            recordResourcesResults.add(fileRecordResourcesResult);
        }
        CommonPageResult<FileRecordResourcesResult> pageResult = CommonPageResult.build(recordResourcesResults,commonPageInfo,fileRecordResourcesPage.getTotal());
        return CommonResult.success(pageResult);
    }
}

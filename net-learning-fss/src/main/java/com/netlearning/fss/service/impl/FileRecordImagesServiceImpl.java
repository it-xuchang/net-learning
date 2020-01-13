package com.netlearning.fss.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.fss.FileRecord;
import com.netlearning.framework.domain.fss.FileRecordExample;
import com.netlearning.framework.domain.fss.FileRecordImages;
import com.netlearning.framework.domain.fss.FileRecordImagesExample;
import com.netlearning.framework.domain.fss.param.FileRecordImagesQueryParam;
import com.netlearning.framework.domain.fss.result.FileRecordImagesResult;
import com.netlearning.framework.domain.fss.result.FileRecordResult;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.fss.mapper.FileRecordImagesMapper;
import com.netlearning.fss.mapper.FileRecordMapper;
import com.netlearning.fss.service.FileRecordImagesService;
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
 * @time: 2019/12/28 23:19
 */
@Service
public class FileRecordImagesServiceImpl implements FileRecordImagesService {
    @Autowired
    private FileRecordMapper fileRecordMapper;

    @Autowired
    private FileRecordImagesMapper fileRecordImagesMapper;
    @Override
    public CommonResult<List<FileRecordImagesResult>> query(FileRecordImagesQueryParam param) {
        FileRecordImagesExample example = new FileRecordImagesExample();
        FileRecordImagesExample.Criteria criteria = example.createCriteria();
        if (param.getRecordImageId() != null){
            criteria.andRecordImageIdEqualTo(param.getRecordImageId());
        }
        if (param.getRecordId() != null){
            criteria.andRecordIdEqualTo(param.getRecordId());
        }
        if (param.getFromSystemId() != null){
            criteria.andFromSystemIdEqualTo(param.getFromSystemId());
        }
        if (param.getUserId() != null){
            criteria.andUserIdEqualTo(param.getUserId());
        }
        if (!StringUtils.isEmpty(param.getIsDefault())){
            criteria.andIsDefaultEqualTo(param.getIsDefault());
        }
        if (!StringUtils.isEmpty(param.getIsDefaultIcon())){
            criteria.andIsDefaultIconEqualTo(param.getIsDefaultIcon());
        }
        if (!CollectionUtils.isEmpty(param.getUserIds())){
            criteria.andUserIdIn(param.getUserIds());
        }
        if (!CollectionUtils.isEmpty(param.getFromSystemIds())){
            criteria.andFromSystemIdIn(param.getFromSystemIds());
        }
        List<Long> recordIds  = new ArrayList<>();
        List<FileRecordImages>  fileRecordImagesList =  fileRecordImagesMapper.selectByExample(example);
        for (FileRecordImages fileRecordImages : fileRecordImagesList){
            if (!recordIds.contains(fileRecordImages.getRecordId())){
                recordIds.add(fileRecordImages.getRecordId());
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
        List<FileRecordImagesResult> results = new ArrayList<>();
        for (FileRecordImages fileRecordImages : fileRecordImagesList){
            FileRecordImagesResult fileRecordImagesResult = new FileRecordImagesResult();
            BeanCopyUtils.copyProperties(fileRecordImages,fileRecordImagesResult);
            if (fileRecordResultMap.containsKey(fileRecordImages.getRecordId())){
                fileRecordImagesResult.setRecord(fileRecordResultMap.get(fileRecordImages.getRecordId()));
                results.add(fileRecordImagesResult);
            }
        }

        return CommonResult.success(results);
    }

    @Override
    public CommonResult page(FileRecordImagesQueryParam param, CommonPageInfo commonPageInfo) {
        FileRecordImagesExample example = new FileRecordImagesExample();
        FileRecordImagesExample.Criteria criteria = example.createCriteria();
        if (param.getRecordImageId() != null){
            criteria.andRecordImageIdEqualTo(param.getRecordImageId());
        }
        if (param.getRecordId() != null){
            criteria.andRecordIdEqualTo(param.getRecordId());
        }
        if (param.getFromSystemId() != null){
            criteria.andFromSystemIdEqualTo(param.getFromSystemId());
        }
        if (param.getUserId() != null){
            criteria.andUserIdEqualTo(param.getUserId());
        }
        if (!StringUtils.isEmpty(param.getIsDefault())){
            criteria.andIsDefaultEqualTo(param.getIsDefault());
        }
        if (!StringUtils.isEmpty(param.getIsDefaultIcon())){
            criteria.andIsDefaultIconEqualTo(param.getIsDefaultIcon());
        }
        PageHelper.startPage(commonPageInfo.getPageNum(),commonPageInfo.getPageSize());
        Page<FileRecordImages> fileRecordImagesList = (Page<FileRecordImages>) fileRecordImagesMapper.selectByExample(example);



        Map<Long, FileRecordResult> fileRecordResultMap = new HashMap<>();
        List<FileRecordImagesResult> results = new ArrayList<>();
        List<Long> recordIds  = new ArrayList<>();
        for (FileRecordImages fileRecordImages : fileRecordImagesList.getResult()){
            if (!recordIds.contains(fileRecordImages.getRecordId())){
                recordIds.add(fileRecordImages.getRecordId());
            }
        }
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
        for (FileRecordImages fileRecordImages : fileRecordImagesList.getResult()){
            FileRecordImagesResult fileRecordImagesResult = new FileRecordImagesResult();
            BeanCopyUtils.copyProperties(fileRecordImages,fileRecordImagesResult);
            if (fileRecordResultMap.containsKey(fileRecordImages.getRecordId())){
                fileRecordImagesResult.setRecord(fileRecordResultMap.get(fileRecordImages.getRecordId()));
                results.add(fileRecordImagesResult);
            }
        }

        CommonPageResult<FileRecordImagesResult> pageResult = CommonPageResult.build(results,commonPageInfo,fileRecordImagesList.getTotal());
        return CommonResult.success(pageResult);
    }
}

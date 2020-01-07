package com.netlearning.fss.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.fss.FileRecordImages;
import com.netlearning.framework.domain.fss.FileRecordImagesExample;
import com.netlearning.framework.domain.fss.param.FileRecordImagesQueryParam;
import com.netlearning.framework.domain.fss.result.FileRecordImagesResult;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.fss.mapper.FileRecordImagesMapper;
import com.netlearning.fss.mapper.FileRecordMapper;
import com.netlearning.fss.service.FileRecordImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public CommonResult query(FileRecordImagesQueryParam param) {
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
        List<FileRecordImages>  fileRecordImagesList =  fileRecordImagesMapper.selectByExample(example);
        List<FileRecordImagesResult> results = BeanCopyUtils.copy(fileRecordImagesList,FileRecordImagesResult.class);
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
        List<FileRecordImagesResult> results = BeanCopyUtils.copy(fileRecordImagesList.getResult(),FileRecordImagesResult.class);
        CommonPageResult<FileRecordImagesResult> pageResult = CommonPageResult.build(results,commonPageInfo,fileRecordImagesList.getTotal());
        return CommonResult.success(pageResult);
    }
}

package com.netlearning.fss.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.FileRecordResources;
import com.netlearning.framework.domain.fss.FileRecordResourcesExample;
import com.netlearning.framework.domain.fss.param.FileRecordResourcesQueryParam;
import com.netlearning.fss.mapper.FileRecordResourcesMapper;
import com.netlearning.fss.service.FileRecordResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<FileRecordResources> fileRecordResources = fileRecordResourcesMapper.selectByExample(example);

        return null;
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
        Page<FileRecordResources> fileRecordResources = (Page<FileRecordResources>) fileRecordResourcesMapper.selectByExample(example);
        return null;
    }
}

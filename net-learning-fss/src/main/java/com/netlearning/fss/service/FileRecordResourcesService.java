package com.netlearning.fss.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.param.FileRecordResourcesQueryParam;
import com.netlearning.framework.domain.fss.result.FileRecordResourcesResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/28 23:20
 */
public interface FileRecordResourcesService {
    CommonResult<List<FileRecordResourcesResult>> query(FileRecordResourcesQueryParam param);

    CommonResult page(FileRecordResourcesQueryParam param, CommonPageInfo commonPageInfo);
}

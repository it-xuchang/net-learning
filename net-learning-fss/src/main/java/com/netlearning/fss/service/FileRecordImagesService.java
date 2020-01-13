package com.netlearning.fss.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.param.FileRecordImagesQueryParam;
import com.netlearning.framework.domain.fss.result.FileRecordImagesResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/28 23:18
 */
public interface FileRecordImagesService {
    CommonResult<List<FileRecordImagesResult>> query(FileRecordImagesQueryParam param);

    CommonResult page(FileRecordImagesQueryParam param, CommonPageInfo commonPageInfo);
}

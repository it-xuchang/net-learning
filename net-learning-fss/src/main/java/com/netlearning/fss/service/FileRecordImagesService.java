package com.netlearning.fss.service;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.param.FileRecordImagesQueryParam;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/28 23:18
 */
public interface FileRecordImagesService {
    CommonResult query(FileRecordImagesQueryParam param);

    CommonResult page(FileRecordImagesQueryParam param, CommonPageInfo commonPageInfo);
}

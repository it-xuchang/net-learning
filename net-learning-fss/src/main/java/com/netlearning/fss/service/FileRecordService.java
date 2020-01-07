package com.netlearning.fss.service;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.param.FileRecordApplyTokenParam;
import com.netlearning.framework.domain.fss.param.FileRecordDowmloadParam;
import com.netlearning.framework.domain.fss.param.FileRecordRemoveParam;
import com.netlearning.framework.domain.fss.param.FileRecordUploadParam;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/28 23:18
 */
public interface FileRecordService {
    CommonResult upload(FileRecordUploadParam param);

    CommonResult mulitipartUpload(FileRecordUploadParam param);

    CommonResult applyUploadToken(FileRecordApplyTokenParam param);

    CommonResult download(FileRecordDowmloadParam param);

    CommonResult remove(FileRecordRemoveParam param);
}

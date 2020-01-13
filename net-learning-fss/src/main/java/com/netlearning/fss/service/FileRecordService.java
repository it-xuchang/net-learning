package com.netlearning.fss.service;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.param.*;
import com.netlearning.framework.domain.fss.result.FileRecordResult;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/28 23:18
 */
public interface FileRecordService {
    CommonResult<List<FileRecordResult>> query(FileRecordQueryParam param);

    CommonResult upload(FileRecordUploadParam param);

    CommonResult mulitipartUpload(FileRecordUploadParam param);

    CommonResult applyUploadToken(FileRecordApplyTokenParam param);

    CommonResult download(FileRecordDowmloadParam param);

    CommonResult remove(FileRecordRemoveParam param);

    CommonResult uploadMedia(FileRecordUploadMediaParam param);
}

package com.netlearning.manage.media.service;

import com.netlearning.framework.domain.media.MediaFile;
import com.netlearning.framework.domain.media.request.QueryMediaFileRequest;
import com.netlearning.framework.model.response.QueryResponseResult;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/12 10:29
 */
public interface MediaFileService {
    QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest);
}

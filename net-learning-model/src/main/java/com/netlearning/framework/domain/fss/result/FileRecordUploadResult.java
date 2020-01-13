package com.netlearning.framework.domain.fss.result;

import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/8 17:58
 */
@Data
public class FileRecordUploadResult {

    private Long recordImageId;

    private Long recordId;

    private Long fromSystemId;

    private Long recordResourcesId;

    private String fileAbsolutePath;

}

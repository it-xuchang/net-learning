package com.netlearning.framework.domain.fss.result;

import lombok.Data;

import java.util.Date;

@Data
public class FileRecordResult {
    private Long recordId;

    private String contentType;

    private String groupName;

    private String remoteFileName;

    private Long fileSize;

    private String fileAbsolutePath;

    private Long uniqueId;

    private String remark;

    private String origFileName;

    private Date createTime;

    private Date updateTime;

    private Long fromSystemId;

    private String fileType;

}

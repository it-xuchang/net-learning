package com.netlearning.framework.domain.fss.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class FileRecordResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordId;

    private String contentType;

    private String groupName;

    private String remoteFileName;

    private Long fileSize;

    private String fileAbsolutePath;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long uniqueId;

    private String remark;

    private String origFileName;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long fromSystemId;

    private String fileType;

}

package com.netlearning.framework.domain.fss;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/4 16:39
 */
@Data
@ToString
public class FileRecord {
    private String  id;
    private String  contentType;
    private String  fromSystemId;
    private Long  fileSize;
    private String  uniqueId;
    private String  remark;
    private String  origFileName;
    private Date cteateTime;
    private Date updateTime;
    private String groupName;
    private String remoteFileName;
    private String fileAbsolutePath;
    private String userId;
}

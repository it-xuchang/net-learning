package com.netlearning.framework.domain.fss.response;

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
public class FileTypeResult {
    private String  id;
    private String  businessType;
    private String  remark;
    private String  fileSize;
    private String  fileType;
    private Date cteateTime;
    private Date updateTime;
}

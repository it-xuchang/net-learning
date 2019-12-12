package com.netlearning.fss.fastdfs;

import lombok.Data;
import lombok.ToString;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/9 16:37
 */
@Data
@ToString
public class FileUploadResult {
    private String groupName;
    private String remoteFileName;
    private String fileAbsolutePath;
}

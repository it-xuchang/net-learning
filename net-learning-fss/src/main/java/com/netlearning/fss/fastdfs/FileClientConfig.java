package com.netlearning.fss.fastdfs;

import java.io.Serializable;

/**
*@program: net-learning
*@description:
*fastdfs
*@author: XUCHANG
*@time: ${DATE} ${TIME}
*/
public interface FileClientConfig extends Serializable {
    public static final String FILE_DEFAULT_AUTHOR = "xuchang";

    public static final String PROTOCOL = "http://";

    public static final String SEPARATOR = "/";

    public static final String TRACKER_NGNIX_ADDR = "134.175.30.90";

    public static final String TRACKER_NGNIX_PORT = "";

    public static final String CLIENT_CONFIG_FILE = "fdfs_client.conf";
}

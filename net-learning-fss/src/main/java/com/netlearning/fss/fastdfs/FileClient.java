package com.netlearning.fss.fastdfs;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.File;

public class FileClient implements FileClientConfig {
    private static final long serialVersionUID = 1L;
    private static TrackerServer trackerServer;
    private static TrackerClient trackerClient;
    private static StorageClient storageClient;

    static {
        try {
            //加载配置文件
            String classPath = new File(FileClient.class.getResource("/").getFile()).getCanonicalPath();
            String fdfsClientConfigFilePath = classPath + File.separator + CLIENT_CONFIG_FILE;
            ClientGlobal.init(fdfsClientConfigFilePath);

            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient = new StorageClient(trackerServer, null);
            //socket  可以  三次
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <strong>方法概要： 文件上传</strong> <br>
     * <strong>创建时间： 2016-9-26 上午10:26:11</strong> <br>
     *
     * @return fileAbsolutePath
     * @author Wang Liang
     */
    public static synchronized String upload(FastDFSFile file, NameValuePair[] valuePairs) {
        // 排队
        String[] uploadResults = null;
        try {
            //5s   50
            uploadResults = storageClient.upload_file(file.getContent(),file.getExt(), valuePairs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String groupName = uploadResults[0];
        String remoteFileName = uploadResults[1];

        String fileAbsolutePath = PROTOCOL
                + TRACKER_NGNIX_ADDR
                + SEPARATOR + groupName
                + SEPARATOR + remoteFileName;
        return fileAbsolutePath;
    }
}

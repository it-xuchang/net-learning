package com.netlearning.fss.fastdfs;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;


public class FileClientPool implements FileClientConfig {
    private static final long serialVersionUID = 1L;
    private static LinkedBlockingQueue<StorageClient> clientQueue=new LinkedBlockingQueue<>();
//    集合   队列
    static {
        try {
            String classPath = new File(FileClientPool.class.getResource("/").getFile()).getCanonicalPath();
            String fdfsClientConfigFilePath = classPath + File.separator + CLIENT_CONFIG_FILE;
            ClientGlobal.init(fdfsClientConfigFilePath);
            //加载配置文件
            for (int i=0;i<5;i++){
                TrackerClient trackerClient = new TrackerClient();
                TrackerServer trackerServer = trackerClient.getConnection();
                StorageClient storageClient = new StorageClient(trackerServer, null);
                clientQueue.add(storageClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <strong>方法概要： 文件上传</strong> <br>
     * <strong>创建时间： 2016-9-26 上午10:26:11</strong> <br>
     * @return fileAbsolutePath
     */
    public static FileUploadResult upload(FastDFSFile file, NameValuePair[] valuePairs) {
        // 排队
        String[] uploadResults = null;
        StorageClient client=null;
        try {
            client= clientQueue.take(); //poll
            uploadResults = client.upload_file(file.getContent(),file.getExt(), valuePairs);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                clientQueue.put(client);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String groupName = uploadResults[0];
        String remoteFileName = uploadResults[1];

        String fileAbsolutePath = PROTOCOL
                + TRACKER_NGNIX_ADDR
                + SEPARATOR + groupName
                + SEPARATOR + remoteFileName;
        FileUploadResult result = new FileUploadResult();
        result.setGroupName(groupName);
        result.setRemoteFileName(remoteFileName);
        result.setFileAbsolutePath(fileAbsolutePath);
        return result;
    }

    /**
     * 文件移除
     * @param groupName
     * @param remoteFileName
     */
    public static void remove(String groupName,String remoteFileName){
        StorageClient client=null;
        try {
            client= clientQueue.take();
            client.delete_file(groupName,remoteFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                clientQueue.put(client);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件下载
     * @param groupName
     * @param remoteFileName
     * @param localFileName
     */
    public static void download(String groupName,String remoteFileName,String localFileName){
        StorageClient client=null;
        try {
            client.download_file(groupName,remoteFileName,localFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                clientQueue.put(client);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

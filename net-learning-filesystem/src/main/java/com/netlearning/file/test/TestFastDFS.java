package com.netlearning.file.test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.netlearning.file.FileApp;

@SpringBootTest//(webEnvironment= SpringBootTest.WebEnvironment.NONE, classes = FileApp.class)
@RunWith(SpringRunner.class)
public class TestFastDFS {

    //上传文件
    @Test
    public void testUpload(){

        try {
            //加载fastdfs-client.properties配置文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            //定义TrackerClient，用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Stroage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
            //创建stroageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storeStorage);
            //向stroage服务器上传文件
            //本地文件的路径
            String filePath = "E:\\图片库\\素材图片\\1.jpg";
            //上传成功后拿到文件Id
            String fileId = storageClient1.upload_file1(filePath, "png", null);
            System.out.println(fileId);
            //group1/M00/00/00/rBAADV0JoNSAQzliAAIBzTYd5sw296.png

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //下载文件
    @Test
    public void testDownload(){
        try {
            //加载fastdfs-client.properties配置文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            //定义TrackerClient，用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Stroage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
            //创建stroageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storeStorage);
            //下载文件
            //文件id
            String fileId = "group1/M00/00/00/rBAADV0JoNSAQzliAAIBzTYd5sw296.png";
            byte[] bytes = storageClient1.download_file1(fileId);
            //使用输出流保存文件
            FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\No\\Desktop\\aa.png"));
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }



}
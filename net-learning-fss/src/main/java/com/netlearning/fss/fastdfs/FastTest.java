package com.netlearning.fss.fastdfs;

import org.csource.common.NameValuePair;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FastTest {
    //单例
    public static void main(String[] args) throws IOException {
        String[] filePaths = new String[]{"C:/Users/xuchang/Pictures/image1.jpg",
                "C:/Users/xuchang/Pictures/image2.jpg",
                "C:/Users/xuchang/Pictures/image4.jpg"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<filePaths.length;i++) {
            String path=filePaths[i];
            Thread thread=new Thread(){
                @Override
                public void run() {
                    try {
                        uploadFile(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(thread);
        }
    }

    private static void uploadFile(String filePath) throws IOException {
        String ext = "jpg";
        FileInputStream fileReader = new FileInputStream(filePath);
        int length = fileReader.available();
        byte[] bytes = new byte[fileReader.available()];
        fileReader.read(bytes);

        FastDFSFile file = new FastDFSFile(bytes, ext);
        NameValuePair[] meta_list = new NameValuePair[4];
        meta_list[0] = new NameValuePair("fileName", "abc");
        meta_list[1] = new NameValuePair("fileLength", String.valueOf(length));
        meta_list[2] = new NameValuePair("fileExt", ext);
        meta_list[3] = new NameValuePair("fileAuthor", "ant");
        FileUploadResult fileUploadResult = FileClientPool.upload(file, null);
        System.out.println(fileUploadResult);
    }
}

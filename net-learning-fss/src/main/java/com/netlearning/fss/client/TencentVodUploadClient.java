package com.netlearning.fss.client;

import com.alibaba.druid.sql.parser.Lexer;
import com.qcloud.vod.VodUploadClient;
import com.qcloud.vod.model.VodUploadRequest;
import com.qcloud.vod.model.VodUploadResponse;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/24 17:51
 */
public class TencentVodUploadClient {
    @Value("{secretId}")
    private String secretId;
    @Value("{secretKey}")
    private String secretKey;

    public static void main(String[] args) {


        VodUploadClient client = new VodUploadClient("AKIDqFTZF0JjUuATGexY1eoS0UnU2aIAlhIh", "OS7NSSN8XjlFYhK6haRZHtkeNkwk8OUX");
        VodUploadRequest request = new VodUploadRequest();
        request.setMediaFilePath("E:\\就业班视频\\01-Java基础\\day15\\15.01_集合框架(对象数组的概述和使用).mp4");
        request.setStorageRegion("ap-guangzhou");
        try {
            VodUploadResponse response = client.upload("ap-guangzhou", request);
            System.out.println(VodUploadResponse.toJsonString(response));
            //{"FileId":"5285890797064739964","MediaUrl":"http://1256082702.vod2.myqcloud.com/0be7c060vodgzp1256082702/aaca79a15285890797064739964/f0.mp4","CoverUrl":"","RequestId":"c1c4cc54-819b-48d7-a1a8-541561ef3e6f"}
        } catch (Exception e) {
            // 业务方进行异常处理
            e.printStackTrace();
        }
    }
}

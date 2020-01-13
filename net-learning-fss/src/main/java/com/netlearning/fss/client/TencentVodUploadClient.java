package com.netlearning.fss.client;

import com.qcloud.vod.VodUploadClient;
import com.qcloud.vod.model.VodUploadRequest;
import com.qcloud.vod.model.VodUploadResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/24 17:51
 */
@Component
public class TencentVodUploadClient {
    @Value("{secretId}")
    private String secretId;
    @Value("{secretKey}")
    private String secretKey;
    @Value("{storageRegion}")
    private String storageRegion;

    public  VodUploadResponse vodUploadClient(String mediaFilePath){
        //secretId：AKIDqFTZF0JjUuATGexY1eoS0UnU2aIAlhIh   secretKey：OS7NSSN8XjlFYhK6haRZHtkeNkwk8OUX
        VodUploadClient client = new VodUploadClient(secretId, secretKey);
        VodUploadRequest request = new VodUploadRequest();
        request.setMediaFilePath(mediaFilePath);
        request.setStorageRegion(storageRegion);
        try {
            VodUploadResponse response = client.upload("ap-guangzhou", request);
            System.out.println(VodUploadResponse.toJsonString(response));
            return response;
            //{"FileId":"5285890797064739964","MediaUrl":"http://1256082702.vod2.myqcloud.com/0be7c060vodgzp1256082702/aaca79a15285890797064739964/f0.mp4","CoverUrl":"","RequestId":"c1c4cc54-819b-48d7-a1a8-541561ef3e6f"}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}

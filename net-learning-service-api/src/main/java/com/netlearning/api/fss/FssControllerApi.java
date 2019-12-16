package com.netlearning.api.fss;

import com.netlearning.framework.base.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/13 11:00
 */
@Api(value = "文件接口", description = "fastdfs的文件的接口，文件的上传，下载，删除")
public interface FssControllerApi {
    public CommonResult upload(MultipartFile[] files,
                               @RequestParam(value = "userId" ,required = false) String userId ,
                               @RequestParam(value = "tokenKey",required = false) String tokenKey);

    public CommonResult download();

    public CommonResult applyUploadToken(@RequestParam(value = "userId" ,required = false) String userId ,
                                         @RequestParam(value = "type",required = false) String type);
}

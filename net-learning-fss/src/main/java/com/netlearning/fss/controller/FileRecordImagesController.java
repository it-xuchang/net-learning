package com.netlearning.fss.controller;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.param.FileRecordImagesQueryParam;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.fss.service.FileRecordImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/28 23:14
 */
@RestController
@RequestMapping("/file/record/images")
public class FileRecordImagesController {
    @Autowired
    private FileRecordImagesService fileRecordImagesService;
    @GetMapping("/query")
    public CommonResult query(@RequestParam(value = "recordImageId",required = false) Long recordImageId,
                              @RequestParam(value = "recordId",required = false) Long recordId,
                              @RequestParam(value = "fromSystemId",required = false) Long fromSystemId,
                              @RequestParam(value = "userId",required = false) Long userId,
                              @RequestParam(value = "isDefault",required = false) String isDefault,
                              @RequestParam(value = "isDefaultIcon",required = false) String isDefaultIcon){
        FileRecordImagesQueryParam param = new FileRecordImagesQueryParam();
        param.setFromSystemId(fromSystemId);
        param.setIsDefault(isDefault);
        param.setRecordId(recordId);
        param.setRecordImageId(recordImageId);
        param.setUserId(userId);
        param.setIsDefaultIcon(isDefaultIcon);
        return fileRecordImagesService.query(param);
    }

    @GetMapping("/page")
    public CommonResult page(@RequestParam(value = "recordImageId",required = false) Long recordImageId,
                              @RequestParam(value = "recordId",required = false) Long recordId,
                              @RequestParam(value = "fromSystemId",required = false) Long fromSystemId,
                              @RequestParam(value = "userId",required = false) Long userId,
                              @RequestParam(value = "isDefault",required = false) String isDefault,
                              @RequestParam(value = "isDefaultIcon",required = false) String isDefaultIcon,
                              @RequestParam(value = "pageNum",required = false) Integer pageNum,
                              @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        FileRecordImagesQueryParam param = new FileRecordImagesQueryParam();
        param.setFromSystemId(fromSystemId);
        param.setIsDefault(isDefault);
        param.setRecordId(recordId);
        param.setRecordImageId(recordImageId);
        param.setUserId(userId);
        param.setIsDefaultIcon(isDefaultIcon);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return fileRecordImagesService.page(param,commonPageInfo);
    }


}

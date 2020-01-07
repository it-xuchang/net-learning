package com.netlearning.fss.controller;

import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.fss.param.FileRecordResourcesQueryParam;
import com.netlearning.framework.domain.fss.result.FileRecordResourcesResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.fss.service.FileRecordResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/28 23:13
 */
@RestController
@RequestMapping("/file/record/images")
public class FileRecordResourcesController {
    @Autowired
    private FileRecordResourcesService fileRecordResourcesService;

    @GetMapping("query")
    private CommonResult query(@RequestParam(value = "recordResourcesId",required = false) Long recordResourcesId,
                                                                @RequestParam(value = "recordId",required = false) Long recordId,
                                                                @RequestParam(value = "fromSystemId",required = false) Long fromSystemId){
        FileRecordResourcesQueryParam param = new FileRecordResourcesQueryParam();
        param.setFromSystemId(fromSystemId);
        param.setRecordId(recordId);
        param.setRecordResourcesId(recordResourcesId);
        return fileRecordResourcesService.query(param);
    }
    @GetMapping("page")
    private CommonResult page( @RequestParam(value = "recordResourcesId",required = false) Long recordResourcesId,
                               @RequestParam(value = "recordId",required = false) Long recordId,
                               @RequestParam(value = "fromSystemId",required = false) Long fromSystemId,
                               @RequestParam(value = "pageNum",required = false) Integer pageNum,
                               @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        FileRecordResourcesQueryParam param = new FileRecordResourcesQueryParam();
        param.setFromSystemId(fromSystemId);
        param.setRecordId(recordId);
        param.setRecordResourcesId(recordResourcesId);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return fileRecordResourcesService.page(param,commonPageInfo);
    }

}

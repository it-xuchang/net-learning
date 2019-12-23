package com.netlearning.user.controller;

import com.netlearning.api.userAuth.DictControllerApi;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.framework.domain.userAuth.Dict;
import com.netlearning.framework.domain.userAuth.DictParam;
import com.netlearning.user.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:43
 */
@RestController
@RequestMapping("dict")
public class DictController implements DictControllerApi {
    @Autowired
    private DictService dictService;

    @Override
    @GetMapping("query")
    public CommonResult<List<Dict>> query(@RequestParam(value = "dictId",required = false) Long dictId,
                                          @RequestParam(value = "key",required = false) Long key,
                                          @RequestParam(value = "value",required = false) String value,
                                          @RequestParam(value = "fieldName",required = false) String fieldName,
                                          @RequestParam(value = "tableName",required = false) String tableName){
        DictParam dictParam = new DictParam();
        dictParam.setDictId(dictId);
        dictParam.setFieldName(fieldName);
        dictParam.setKey(key);
        dictParam.setTableName(tableName);
        dictParam.setValue(value);
        return dictService.query(dictParam);
    }
    @Override
    @GetMapping("page")
    public CommonResult<CommonPageResult<Dict>> page(@RequestParam(value = "dictId",required = false) Long dictId,
                                                     @RequestParam(value = "key",required = false) Long key,
                                                     @RequestParam(value = "value",required = false) String value,
                                                     @RequestParam(value = "fieldName",required = false) String fieldName,
                                                     @RequestParam(value = "tableName",required = false) String tableName,
                                                     @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
        DictParam dictParam = new DictParam();
        dictParam.setDictId(dictId);
        dictParam.setFieldName(fieldName);
        dictParam.setKey(key);
        dictParam.setTableName(tableName);
        dictParam.setValue(value);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return dictService.page(dictParam,commonPageInfo);
    }

    @Override
    @PostMapping("add")
    public CommonResult<Boolean> add(@RequestBody Dict dict){
        return dictService.add(dict);
    }

    @Override
    @PostMapping("edit")
    public CommonResult<Boolean> edit(@RequestBody Dict dict){
        return dictService.edit(dict);
    }

    @Override
    @DeleteMapping("delete")
    public CommonResult<Boolean> delete(Long dictId){
        return dictService.delete(dictId);
    }
}

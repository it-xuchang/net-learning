package com.netlearning.api.userAuth;

import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.Dict;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/23 10:49
 */
@Api(value = "数据字典",description = "数据字典管理")
public interface DictControllerApi {
    public CommonResult<List<Dict>> query(@RequestParam(value = "dictId",required = false) Long dictId,
                                          @RequestParam(value = "key",required = false) Long key,
                                          @RequestParam(value = "value",required = false) String value,
                                          @RequestParam(value = "fieldName",required = false) String fieldName,
                                          @RequestParam(value = "tableName",required = false) String tableName);

    public CommonResult<CommonPageResult<Dict>> page(@RequestParam(value = "dictId",required = false) Long dictId,
                                                     @RequestParam(value = "key",required = false) Long key,
                                                     @RequestParam(value = "value",required = false) String value,
                                                     @RequestParam(value = "fieldName",required = false) String fieldName,
                                                     @RequestParam(value = "tableName",required = false) String tableName,
                                                     @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize);

    public CommonResult<Boolean> add(@RequestBody Dict dict);

    public CommonResult<Boolean> edit(@RequestBody Dict dict);

    public CommonResult<Boolean> delete(Long dictId);

}

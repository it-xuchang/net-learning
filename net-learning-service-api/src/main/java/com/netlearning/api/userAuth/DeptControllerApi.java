package com.netlearning.api.userAuth;

import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.Dept;
import com.netlearning.framework.domain.userAuth.param.DeptAddParam;
import com.netlearning.framework.domain.userAuth.param.DeptDeleteParam;
import com.netlearning.framework.domain.userAuth.param.DeptEditParam;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/23 10:36
 */
@Api(value = "用户管理",description = "用户管理")
public interface DeptControllerApi {

    public CommonResult<List<Dept>> query(@RequestParam(value = "deptId",required = false) Long deptId,
                                          @RequestParam(value = "parentId",required = false) Long parentId,
                                          @RequestParam(value = "deptName",required = false) String deptName,
                                          @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                          @RequestParam(value = "endCreateTime",required = false) String endCreateTime);

    public CommonResult<CommonPageResult<Dept>> page(@RequestParam(value = "deptId",required = false) Long deptId,
                                                     @RequestParam(value = "parentId",required = false) Long parentId,
                                                     @RequestParam(value = "deptName",required = false) String deptName,
                                                     @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                                     @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                                     @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize);

    public CommonResult<Boolean> add(@RequestBody DeptAddParam dept);

    public CommonResult<Boolean> edit(@RequestBody DeptEditParam dept);

    public CommonResult<Boolean> delete(@RequestBody DeptDeleteParam dept);
}

package com.netlearning.user.controller;

import com.netlearning.api.userAuth.DeptControllerApi;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.framework.domain.userAuth.Dept;
import com.netlearning.framework.domain.userAuth.DeptParam;
import com.netlearning.user.service.DeptServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:40
 */
@RestController
@RequestMapping("dept")
public class DeptController implements DeptControllerApi {
    @Autowired
    private DeptServcie deptServcie;

    @Override
    @GetMapping("query")
    public CommonResult<List<Dept>> query(@RequestParam(value = "deptId",required = false) Long deptId,
                                          @RequestParam(value = "parentId",required = false) Long parentId,
                                          @RequestParam(value = "deptName",required = false) String deptName,
                                          @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                          @RequestParam(value = "endCreateTime",required = false) String endCreateTime){
//        if (!RegexUtil.checkDatePattern(startCreateTime) && !RegexUtil.checkDatePattern(endCreateTime)){
//            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE006.code,ExceptionCode.UserAuthCode.CODE006.message);
//        }
        DeptParam param = new DeptParam();
        param.setDeptId(deptId);
        param.setDeptName(deptName);
        param.setStartCreateTime(startCreateTime);
        param.setEndCreateTime(endCreateTime);
        param.setParentId(parentId);
        return deptServcie.query(param);
    }
    @Override
    @GetMapping("page")
    public CommonResult<CommonPageResult<Dept>> page(@RequestParam(value = "deptId",required = false) Long deptId,
                                                     @RequestParam(value = "parentId",required = false) Long parentId,
                                                     @RequestParam(value = "deptName",required = false) String deptName,
                                                     @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                                     @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                                     @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize){

        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }
//        if (!RegexUtil.checkDatePattern(startCreateTime) && !RegexUtil.checkDatePattern(endCreateTime)){
//            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE006.code,ExceptionCode.UserAuthCode.CODE006.message);
//        }
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        DeptParam param = new DeptParam();
        param.setDeptId(deptId);
        param.setDeptName(deptName);
        param.setStartCreateTime(startCreateTime);
        param.setEndCreateTime(endCreateTime);
        param.setParentId(parentId);
        return deptServcie.page(param,commonPageInfo);
    }

    @Override
    @PostMapping("add")
    public CommonResult<Boolean> add(@RequestBody Dept dept){
        if (StringUtils.isEmpty(dept.getDeptName())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        return deptServcie.add(dept);
    }

    @Override
    @PostMapping("edit")
    public CommonResult<Boolean> edit(@RequestBody Dept dept){
        if (StringUtils.isEmpty(dept.getDeptName())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (!RegexUtil.checkPositNum(dept.getDeptId())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        return deptServcie.edit(dept);
    }

    @Override
    @DeleteMapping("delete")
    public CommonResult<Boolean> delete(Long deptId){
        return deptServcie.delete(deptId);
    }
}

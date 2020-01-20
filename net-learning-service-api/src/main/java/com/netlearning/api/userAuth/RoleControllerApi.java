package com.netlearning.api.userAuth;

import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.Role;
import com.netlearning.framework.domain.userAuth.RoleAddRequest;
import com.netlearning.framework.domain.userAuth.RoleDeleteRequest;
import com.netlearning.framework.domain.userAuth.RoleEditRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/23 10:50
 */
@Api(value = "角色管理",description = "角色管理")
public interface RoleControllerApi {

    public CommonResult<List<Role>> query(@RequestParam(value = "roleId",required = false) Long roleId,
                                          @RequestParam(value = "roleName",required = false) String roleName,
                                          @RequestParam(value = "remark",required = false) String remark,
                                          @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                          @RequestParam(value = "endCreateTime",required = false) String endCreateTime);

    public CommonResult<CommonPageResult<Role>> page(@RequestParam(value = "roleId",required = false) Long roleId,
                                                     @RequestParam(value = "roleName",required = false) String roleName,
                                                     @RequestParam(value = "remark",required = false) String remark,
                                                     @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                                     @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                                     @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize);

    public CommonResult<Boolean> add(@RequestBody RoleAddRequest role);

    public CommonResult<Boolean> edit(@RequestBody RoleEditRequest roleEditRequest);

    public CommonResult<Boolean> delete(@RequestBody RoleDeleteRequest roleDeleteRequest);
}

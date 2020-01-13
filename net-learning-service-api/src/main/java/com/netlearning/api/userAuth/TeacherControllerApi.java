package com.netlearning.api.userAuth;

import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.Teacher;
import com.netlearning.framework.domain.userAuth.TeacherAddRequest;
import com.netlearning.framework.domain.userAuth.result.TeacherResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/23 10:52
 */
@Api(value = "教师管理",description = "教师管理")
public interface TeacherControllerApi {

    public CommonResult<List<TeacherResult>> query(@RequestParam(value = "teacherId",required = false) Long teacherId,
                                                   @RequestParam(value = "teacherName",required = false) String teacherName,
                                                   @RequestParam(value = "email",required = false) String email,
                                                   @RequestParam(value = "password",required = false) String password,
                                                   @RequestParam(value = "mobile",required = false) String mobile,
                                                   @RequestParam(value = "status",required = false) String status,
                                                   @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                                   @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                                   @RequestParam(value = "sex",required = false) String sex,
                                                   @RequestParam(value = "description",required = false) String description,
                                                   @RequestParam(value = "avatar",required = false) String avatar,
                                                   @RequestParam(value = "deptId",required = false) Long deptId);


    public CommonResult<CommonPageResult<TeacherResult>> page(@RequestParam(value = "teacherId",required = false) Long teacherId,
                                                        @RequestParam(value = "teacherName",required = false) String teacherName,
                                                        @RequestParam(value = "email",required = false) String email,
                                                        @RequestParam(value = "password",required = false) String password,
                                                        @RequestParam(value = "mobile",required = false) String mobile,
                                                        @RequestParam(value = "status",required = false) String status,
                                                        @RequestParam(value = "startCreateTime",required = false) String startCreateTime,
                                                        @RequestParam(value = "endCreateTime",required = false) String endCreateTime,
                                                        @RequestParam(value = "sex",required = false) String sex,
                                                        @RequestParam(value = "description",required = false) String description,
                                                        @RequestParam(value = "avatar",required = false) String avatar,
                                                        @RequestParam(value = "deptId",required = false) Long deptId,
                                                        @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                        @RequestParam(value = "pageSize",required = false) Integer pageSize);

    public CommonResult<Boolean> add(@RequestBody TeacherAddRequest teacher);

    public CommonResult<Boolean> edit(@RequestBody Teacher teacher);

    public CommonResult<Boolean> delete(Long teacherId);

}

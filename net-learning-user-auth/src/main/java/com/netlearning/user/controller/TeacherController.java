package com.netlearning.user.controller;

import com.netlearning.api.userAuth.TeacherControllerApi;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.framework.domain.userAuth.Teacher;
import com.netlearning.framework.domain.userAuth.TeacherParam;
import com.netlearning.user.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 17:14
 */
@RestController
@RequestMapping("teacher")
public class TeacherController implements TeacherControllerApi {
    @Autowired
    private TeacherService teacherService;

    @Override
    @GetMapping("query")
    public CommonResult<List<Teacher>> query(@RequestParam(value = "teacherId",required = false) Long teacherId,
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
                                             @RequestParam(value = "deptId",required = false) Long deptId){
        TeacherParam teacherParam = new TeacherParam();
        teacherParam.setAvatar(avatar);
        teacherParam.setDeptId(deptId);
        teacherParam.setEmail(email);
        teacherParam.setEndCreateTime(endCreateTime);
        teacherParam.setStartCreateTime(startCreateTime);
        teacherParam.setMobile(mobile);
        teacherParam.setPassword(password);
        teacherParam.setSex(sex);
        teacherParam.setDescription(description);
        teacherParam.setStatus(status);
        teacherParam.setTeacherId(teacherId);
        teacherParam.setTeacherName(teacherName);
        return teacherService.query(teacherParam);
    }
    @Override
    @GetMapping("page")
    public CommonResult<CommonPageResult<Teacher>> page(@RequestParam(value = "teacherId",required = false) Long teacherId,
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
                                                        @RequestParam(value = "pageSize",required = false) Integer pageSize){
        if (pageNum == null ||  pageSize == null || !RegexUtil.checkPositiveNum(pageNum) || !RegexUtil.checkPositiveNum(pageSize)){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE005.code,ExceptionCode.UserAuthCode.CODE005.message);
        }

        TeacherParam teacherParam = new TeacherParam();
        teacherParam.setAvatar(avatar);
        teacherParam.setDeptId(deptId);
        teacherParam.setEmail(email);
        teacherParam.setEndCreateTime(endCreateTime);
        teacherParam.setStartCreateTime(startCreateTime);
        teacherParam.setMobile(mobile);
        teacherParam.setPassword(password);
        teacherParam.setSex(sex);
        teacherParam.setDescription(description);
        teacherParam.setStatus(status);
        teacherParam.setTeacherId(teacherId);
        teacherParam.setTeacherName(teacherName);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return teacherService.page(teacherParam,commonPageInfo);
    }

    @Override
    @PostMapping("add")
    public CommonResult<Boolean> add(@RequestBody Teacher teacher){
        if (StringUtils.isEmpty(teacher.getTeacherName())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (StringUtils.isEmpty(teacher.getPassword())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE009.code,ExceptionCode.UserAuthCode.CODE009.message);
        }
        if (StringUtils.isEmpty(teacher.getMobile()) && StringUtils.isEmpty(teacher.getEmail())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE010.code,ExceptionCode.UserAuthCode.CODE010.message);
        }
        return teacherService.add(teacher);
    }

    @Override
    @PostMapping("edit")
    public CommonResult<Boolean> edit(@RequestBody Teacher teacher){
        if (teacher.getTeacherId() == null){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (StringUtils.isEmpty(teacher.getTeacherName())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (StringUtils.isEmpty(teacher.getPassword())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE009.code,ExceptionCode.UserAuthCode.CODE009.message);
        }
        if (StringUtils.isEmpty(teacher.getMobile()) && StringUtils.isEmpty(teacher.getEmail())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE010.code,ExceptionCode.UserAuthCode.CODE010.message);
        }
        return teacherService.edit(teacher);
    }

    @Override
    @DeleteMapping("delete")
    public CommonResult<Boolean> delete(Long teacherId){
        return teacherService.delete(teacherId);
    }

}

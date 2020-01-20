package com.netlearning.user.controller;

import com.netlearning.api.userAuth.UserControllerApi;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.userAuth.UserAddRequest;
import com.netlearning.framework.domain.userAuth.param.MyCoursQueryParam;
import com.netlearning.framework.domain.userAuth.param.UserChangePasswordParam;
import com.netlearning.framework.domain.userAuth.param.UserDeleteParam;
import com.netlearning.framework.domain.userAuth.param.UserEditParam;
import com.netlearning.framework.domain.userAuth.result.MyCourseResult;
import com.netlearning.framework.domain.userAuth.result.UserResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.framework.utils.StringUtils;
import com.netlearning.framework.domain.userAuth.User;
import com.netlearning.framework.domain.userAuth.UserParam;
import com.netlearning.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:44
 */
@RestController
@RequestMapping("/user")
public class UserController implements UserControllerApi {
    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/query")
    public CommonResult<List<UserResult>> query(@RequestParam(value = "userId",required = false) Long userId,
                                                @RequestParam(value = "userIds",required = false) List<Long> userIds,
                                                @RequestParam(value = "username",required = false) String username,
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
        UserParam userParam = new UserParam();
        userParam.setAvatar(avatar);
        userParam.setDeptId(deptId);
        userParam.setEmail(email);
        userParam.setEndCreateTime(endCreateTime);
        userParam.setStartCreateTime(startCreateTime);
        userParam.setMobile(mobile);
        userParam.setPassword(password);
        userParam.setSex(sex);
        userParam.setDescription(description);
        userParam.setStatus(status);
        userParam.setUserId(userId);
        userParam.setUsername(username);
        userParam.setUserIds(userIds);
        return userService.query(userParam);
    }
    @Override
    @GetMapping("/page")
    public CommonResult<CommonPageResult<UserResult>> page(@RequestParam(value = "userId",required = false) Long userId,
                                                     @RequestParam(value = "username",required = false) String username,
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
        UserParam userParam = new UserParam();
        userParam.setAvatar(avatar);
        userParam.setDeptId(deptId);
        userParam.setEmail(email);
        userParam.setEndCreateTime(endCreateTime);
        userParam.setStartCreateTime(startCreateTime);
        userParam.setMobile(mobile);
        userParam.setPassword(password);
        userParam.setSex(sex);
        userParam.setDescription(description);
        userParam.setStatus(status);
        userParam.setUserId(userId);
        userParam.setUsername(username);
        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return userService.page(userParam,commonPageInfo);
    }

    /**
     * 添加学生用户
     * 必填：手机号或者邮箱号、用户名 、 密码
     * @param user
     * @return
     */
    @Override
    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody UserAddRequest user){
        if (StringUtils.isEmpty(user.getUsername())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (StringUtils.isEmpty(user.getPassword())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE009.code,ExceptionCode.UserAuthCode.CODE009.message);
        }
        if (StringUtils.isEmpty(user.getMobile()) && StringUtils.isEmpty(user.getEmail())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE010.code,ExceptionCode.UserAuthCode.CODE010.message);
        }
        if (!StringUtils.isEmpty(user.getMobile()) && !RegexUtil.checkMobilePattern(user.getMobile())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE005.code,ExceptionCode.AuthCode.CODE005.message);
        }
        if (!RegexUtil.checkEmailPattern(user.getEmail()) && !StringUtils.isEmpty(user.getEmail())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE006.code,ExceptionCode.AuthCode.CODE006.message);
        }
        return userService.add(user);
    }

    @Override
    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody UserEditParam user){
        if (user.getUserId() == null){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (StringUtils.isEmpty(user.getUsername())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE007.code,ExceptionCode.UserAuthCode.CODE007.message);
        }
        if (StringUtils.isEmpty(user.getMobile()) && StringUtils.isEmpty(user.getEmail())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE010.code,ExceptionCode.UserAuthCode.CODE010.message);
        }
        if (!StringUtils.isEmpty(user.getMobile()) && !RegexUtil.checkMobilePattern(user.getMobile())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE005.code,ExceptionCode.AuthCode.CODE005.message);
        }
        if (!RegexUtil.checkEmailPattern(user.getEmail()) && !StringUtils.isEmpty(user.getEmail())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE006.code,ExceptionCode.AuthCode.CODE006.message);
        }
        return userService.edit(user);
    }

    @Override
    @PostMapping("/delete")
    public CommonResult<Boolean> delete(@RequestBody UserDeleteParam param){
        return userService.delete(param);
    }

    @GetMapping("/query/detail")
    public CommonResult<List<UserResult>> queryByUserIds(@RequestParam(value = "userIds",required = false) List<Long> userIds){
        UserParam userParam = new UserParam();
        userParam.setUserIds(userIds);
        return userService.query(userParam);
    }

    @GetMapping("/query/my/course")
    public CommonResult<MyCourseResult> queryMyCourse(@RequestParam(value = "userId",required = false) Long userId){

        MyCoursQueryParam param = new MyCoursQueryParam();
        param.setUserId(userId);
        return userService.queryMyCourse(param);
    }
    @PostMapping("/change/password")
    public CommonResult changePassword(@RequestBody UserChangePasswordParam param){
        if (StringUtils.isEmpty(param.getOldPassword())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE021.code,ExceptionCode.UserAuthCode.CODE021.message);
        }
        if (StringUtils.isEmpty(param.getNewPassword())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE021.code,ExceptionCode.UserAuthCode.CODE021.message);
        }
        if (StringUtils.isEmpty(param.getMobile()) && StringUtils.isEmpty(param.getEmail())){
            return CommonResult.fail(ExceptionCode.UserAuthCode.CODE010.code,ExceptionCode.UserAuthCode.CODE010.message);
        }
        if (!StringUtils.isEmpty(param.getMobile()) && !RegexUtil.checkMobilePattern(param.getMobile())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE005.code,ExceptionCode.AuthCode.CODE005.message);
        }
        if (!RegexUtil.checkEmailPattern(param.getEmail()) && !StringUtils.isEmpty(param.getEmail())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE006.code,ExceptionCode.AuthCode.CODE006.message);
        }
        return userService.changePassword(param);
    }
}

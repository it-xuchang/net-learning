package com.netlearning.auth.service.impl;

import com.netlearning.auth.client.TeacherControllerClientApi;
import com.netlearning.auth.client.UserControllerClientApi;
import com.netlearning.auth.service.UserAccessService;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.auth.param.UserAccessChangePasswordParam;
import com.netlearning.framework.domain.auth.param.UserAccessLoginParam;
import com.netlearning.framework.domain.auth.param.UserAccessRegisterParam;
import com.netlearning.framework.domain.auth.result.UserAccessLoginResult;
import com.netlearning.framework.domain.userAuth.TeacherAddRequest;
import com.netlearning.framework.domain.userAuth.UserAddRequest;
import com.netlearning.framework.domain.userAuth.result.UserResult;
import com.netlearning.framework.em.UserAuthConstants;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.MD5Util;
import com.netlearning.framework.utils.RegexUtil;
import com.netlearning.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/11 14:18
 */
@Service
public class UserAccessServiceImpl implements UserAccessService {
    @Autowired
    private UserControllerClientApi userControllerClientApi;
    @Autowired
    private TeacherControllerClientApi teacherControllerClientApi;

    @Override
    public CommonResult<UserAccessLoginResult> login(UserAccessLoginParam param) {
        //校验输入信息是否正确--正则校验
        if (StringUtils.equals(param.getUserAccountType(), UserAuthConstants.UserLoginType.EMAIL.getCode())){
            if (!RegexUtil.checkEmailPattern(param.getUserAccount())){
                return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
            }
            if(StringUtils.equals(param.getUserType(),UserAuthConstants.UserLoginAccountType.TEACHER.getCode())){

            } else if (StringUtils.equals(param.getUserType(),UserAuthConstants.UserLoginAccountType.USER.getCode())) {

            }
        }else if (StringUtils.equals(param.getUserAccountType(), UserAuthConstants.UserLoginType.MOBILE.getCode())){
            if (!RegexUtil.checkMobilePattern(param.getUserAccount())){
                return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
            }
        }else {
            return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
        }

        //登录的用户类型 学生--教师
        //登录的账号类型 手机号--邮箱
        //查询账号
        //查询密码
        //查询是否锁定


        return null;
    }

    @Override
    @Transactional
    public CommonResult registry(UserAccessRegisterParam param) {
        try {
            //查询该用户是否注册过

            if(StringUtils.equals(param.getUserType(),UserAuthConstants.UserLoginAccountType.TEACHER.getCode())){
                //教师注册
                TeacherAddRequest teacher = new TeacherAddRequest();
                BeanCopyUtils.copyProperties(param,teacher);
                CommonResult<Boolean> teacherResult = teacherControllerClientApi.add(teacher);
                if (!teacherResult.isSuccess()){
                    return CommonResult.fail(teacherResult.getReturnCode(),"调用用户模块微服务报错：" + teacherResult.getReturnMsg());
                }

            } else if (StringUtils.equals(param.getUserType(),UserAuthConstants.UserLoginAccountType.USER.getCode())) {
                //学生注册
                UserAddRequest userAddRequest = new UserAddRequest();
                BeanCopyUtils.copyProperties(param,userAddRequest);
                CommonResult<Boolean> userResult = userControllerClientApi.add(userAddRequest);
                if (!userResult.isSuccess()){
                    return CommonResult.fail(userResult.getReturnCode(),"调用用户模块微服务报错：" + userResult.getReturnMsg());
                }
            }




            param.setPassword(MD5Util.getStringMD5(param.getPassword()));
            return CommonResult.success(param);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
        }

    }

    @Override
    public CommonResult changePassword(UserAccessChangePasswordParam param) {
        return null;
    }
}

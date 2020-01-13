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
import com.netlearning.framework.domain.auth.result.UserLoginResult;
import com.netlearning.framework.domain.userAuth.TeacherAddRequest;
import com.netlearning.framework.domain.userAuth.UserAddRequest;
import com.netlearning.framework.domain.userAuth.result.TeacherResult;
import com.netlearning.framework.em.UserAuthConstants;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${tokenExpireTime}")
    private Long tokenExpireTime;
    @Override
    public CommonResult<UserAccessLoginResult> login(UserAccessLoginParam param) {
        //校验输入信息是否正确--正则校验
        if (StringUtils.isEmpty(param.getPassword())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
        }
        if (StringUtils.isEmpty(param.getUserAccount())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
        }
        if (StringUtils.isEmpty(param.getUserAccountType())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
        }
        if (StringUtils.isEmpty(param.getUserType())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
        }
        //登录的用户类型 学生--教师
        //登录的账号类型 手机号--邮箱
        //查询账号是否存在
        //查询密码
        //查询是否锁定

        if(StringUtils.equals(param.getUserType(),UserAuthConstants.UserLoginAccountType.TEACHER.getCode())){
            //教师账号登录
            return this.getTeacherLogin(param);
        } else if (StringUtils.equals(param.getUserType(),UserAuthConstants.UserLoginAccountType.USER.getCode())) {
            //普通用户账号登录
            return this.getUserLogin(param);
        }else {
            return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
        }
    }

    private CommonResult<UserAccessLoginResult> getTeacherLogin(UserAccessLoginParam param) {
        List<TeacherResult> teacherResult = new ArrayList<>();
        if (StringUtils.equals(param.getUserAccountType(), UserAuthConstants.UserLoginType.EMAIL.getCode())){
            if (!RegexUtil.checkEmailPattern(param.getUserAccount())){
                return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
            }
            CommonResult<List<TeacherResult>> teacherEmailResult  = teacherControllerClientApi.queryByEmail(param.getUserAccount(),param.getPassword());
            if (!teacherEmailResult.isSuccess()){
                return CommonResult.fail(teacherEmailResult.getReturnCode(),"调用用户微服务失败：" + teacherEmailResult.getReturnMsg());
            }
            List<TeacherResult> teacherResultList = teacherEmailResult.getData();
            if (!CollectionUtils.isEmpty(teacherResultList)){
                teacherResult.addAll(teacherResultList);
            }

        }else if (StringUtils.equals(param.getUserAccountType(), UserAuthConstants.UserLoginType.MOBILE.getCode())){
            if (!RegexUtil.checkMobilePattern(param.getUserAccount())){
                return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
            }
            CommonResult<List<TeacherResult>> teacherMobileResult  = teacherControllerClientApi.queryByMobile(param.getUserAccount(),param.getPassword());
            if (!teacherMobileResult.isSuccess()){
                return CommonResult.fail(teacherMobileResult.getReturnCode(),"调用用户微服务失败：" + teacherMobileResult.getReturnMsg());
            }
            List<TeacherResult> teacherResultList = teacherMobileResult.getData();
            if (!CollectionUtils.isEmpty(teacherResultList)){
                teacherResult.addAll(teacherResultList);
            }

        }else {
            return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
        }


        UserAccessLoginResult userAccessLoginResult = new UserAccessLoginResult();
        if (!CollectionUtils.isEmpty(teacherResult)){
            TeacherResult teacher = teacherResult.get(0);
            if (StringUtils.equals(teacher.getStatus(),UserAuthConstants.UserType.DOWN.getCode())){
                return CommonResult.fail(ExceptionCode.AuthCode.CODE004.code,ExceptionCode.AuthCode.CODE004.message);
            }
        }else {
            return CommonResult.fail(ExceptionCode.AuthCode.CODE003.code,ExceptionCode.AuthCode.CODE003.message);
        }

        //设置cookie
        //设置redis的token和过期时间
        String token = UUIDUtils.uuid();
        TeacherResult teacher = teacherResult.get(0);
        Long teacherId = teacher.getTeacherId();

        //先判断用户id是否有过登录状态,执行删除操作
        String tokenValue = (String) redisTemplate.opsForValue().get(teacherId);
        if (!StringUtils.isEmpty(tokenValue)){
            redisTemplate.delete(tokenValue);
            redisTemplate.delete(teacherId);
        }
        //重新写入登录状态的信息
        UserLoginResult userLoginResult = new UserLoginResult();
        userLoginResult.setUserId(teacherId);
        redisTemplate.opsForValue().set(teacherId,token,tokenExpireTime, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set(token,userLoginResult,tokenExpireTime, TimeUnit.MINUTES);

        //判断登录的状态实现单点登录

        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.addCookie(cookie);

//        CookieUtil.addCookie(response,token,"/",);
        return CommonResult.success(userAccessLoginResult);
    }

    private CommonResult<UserAccessLoginResult> getUserLogin(UserAccessLoginParam param) {

        if (StringUtils.equals(param.getUserAccountType(), UserAuthConstants.UserLoginType.EMAIL.getCode())){
            if (!RegexUtil.checkEmailPattern(param.getUserAccount())){
                return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
            }
            userControllerClientApi.queryByEmail(param.getUserAccount(),param.getPassword());
        }else if (StringUtils.equals(param.getUserAccountType(), UserAuthConstants.UserLoginType.MOBILE.getCode())){
            if (!RegexUtil.checkMobilePattern(param.getUserAccount())){
                return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
            }
            userControllerClientApi.queryByMobile(param.getUserAccount(),param.getPassword());

        }else {
            return CommonResult.fail(ExceptionCode.AuthCode.CODE001.code,ExceptionCode.AuthCode.CODE001.message);
        }

        UserAccessLoginResult userAccessLoginResult = new UserAccessLoginResult();
        //设置cookie
        //设置redis的token和过期时间
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
        //登录状态
        //未登录状态
        return null;
    }
}

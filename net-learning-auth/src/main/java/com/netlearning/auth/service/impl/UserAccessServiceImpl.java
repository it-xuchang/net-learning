package com.netlearning.auth.service.impl;

import com.netlearning.auth.client.RoleMenuControllerClientApi;
import com.netlearning.auth.client.TeacherControllerClientApi;
import com.netlearning.auth.client.UserControllerClientApi;
import com.netlearning.auth.client.UserRoleControllerClientApi;
import com.netlearning.auth.service.UserAccessService;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.auth.param.UserAccessChangePasswordParam;
import com.netlearning.framework.domain.auth.param.UserAccessCodeParam;
import com.netlearning.framework.domain.auth.param.UserAccessLoginParam;
import com.netlearning.framework.domain.auth.param.UserAccessRegisterParam;
import com.netlearning.framework.domain.auth.result.UserAccessLoginResult;
import com.netlearning.framework.domain.auth.result.UserLoginResult;
import com.netlearning.framework.domain.userAuth.*;
import com.netlearning.framework.domain.userAuth.result.TeacherResult;
import com.netlearning.framework.domain.userAuth.result.UserResult;
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
    private UserRoleControllerClientApi userRoleControllerClientApi;
    @Autowired
    private RoleMenuControllerClientApi roleMenuControllerClientApi;
    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${tokenExpireTime}")
    private Long tokenExpireTime;
    @Value("${codeExpireTime}")
    private Long codeExpireTime;
    @Value("${cookieDomain}")
    private String cookieDomain;
    @Value("${cookiePath}")
    private String cookiePath;
    @Value("${cookieTime}")
    private int cookieTime;

    @Override
    @Transactional
    public CommonResult<UserAccessLoginResult> login(UserAccessLoginParam param) {
        //校验输入信息是否正确--正则校验
        if (StringUtils.isEmpty(param.getPassword())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE007.code,ExceptionCode.AuthCode.CODE007.message);
        }
        if (StringUtils.isEmpty(param.getUserAccount())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE007.code,ExceptionCode.AuthCode.CODE007.message);
        }
        if (StringUtils.isEmpty(param.getUserAccountType())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE008.code,ExceptionCode.AuthCode.CODE008.message);
        }
        if (StringUtils.isEmpty(param.getUserType())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE009.code,ExceptionCode.AuthCode.CODE009.message);
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
            return CommonResult.fail(ExceptionCode.AuthCode.CODE009.code,ExceptionCode.AuthCode.CODE009.message);
        }
    }

    /**
     * 教师登录
     * @param param
     * @return
     */
    private CommonResult<UserAccessLoginResult> getTeacherLogin(UserAccessLoginParam param) {
        List<TeacherResult> teacherResult = new ArrayList<>();
        if (StringUtils.equals(param.getUserAccountType(), UserAuthConstants.UserLoginType.EMAIL.getCode())){
            if (!RegexUtil.checkEmailPattern(param.getUserAccount())){
                return CommonResult.fail(ExceptionCode.AuthCode.CODE006.code,ExceptionCode.AuthCode.CODE006.message);
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
                return CommonResult.fail(ExceptionCode.AuthCode.CODE005.code,ExceptionCode.AuthCode.CODE005.message);
            }
            CommonResult<List<TeacherResult>> teacherMobileResult  = teacherControllerClientApi.queryByMobile(param.getUserAccount(),param.getPassword());
            if (!teacherMobileResult.isSuccess()){
                return CommonResult.fail(teacherMobileResult.getReturnCode(),"调用教师用户微服务失败" );
            }
            List<TeacherResult> teacherResultList = teacherMobileResult.getData();
            if (!CollectionUtils.isEmpty(teacherResultList)){
                teacherResult.addAll(teacherResultList);
            }
        }else {
            return CommonResult.fail(ExceptionCode.AuthCode.CODE008.code,ExceptionCode.AuthCode.CODE008.message);
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
        String teacherId = String.valueOf(teacher.getTeacherId());

        //先判断用户id是否有过登录状态,执行删除操作
        String tokenValue = (String) redisTemplate.opsForValue().get(teacherId);
        if (!StringUtils.isEmpty(tokenValue)){
            redisTemplate.delete(tokenValue);
            redisTemplate.delete(teacherId);
        }
        //重新写入登录状态的信息
        UserLoginResult userLoginResult = new UserLoginResult();
        userLoginResult.setTeacher(teacher);
        //查询用户权限
        CommonResult<List<UserRoleResult>> userRoleResult = userRoleControllerClientApi.query(teacher.getTeacherId());
        if (!userRoleResult.isSuccess()){
            return CommonResult.fail(userRoleResult.getReturnCode(),"调用用户角色微服务失败");
        }
        if (CollectionUtils.isEmpty(userRoleResult.getData())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE010.code,ExceptionCode.AuthCode.CODE010.message);
        }
        userLoginResult.setRole(userRoleResult.getData().get(0).getRole());
        userAccessLoginResult.setRoleId(userRoleResult.getData().get(0).getRole().getRoleId());
        CommonResult<List<MenuItem>> roleMenuResultCommonResult = roleMenuControllerClientApi.tree(userRoleResult.getData().get(0).getRole().getRoleId());
        if (!userRoleResult.isSuccess()){
            return CommonResult.fail(userRoleResult.getReturnCode(),"调用用户角色资源微服务失败");
        }
        if (CollectionUtils.isEmpty(roleMenuResultCommonResult.getData())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE011.code,ExceptionCode.AuthCode.CODE011.message);
        }
        //查询用户菜单
        //查询用户菜单
        CommonResult<RoleMenuResult> roleMenuResult = roleMenuControllerClientApi.query(userRoleResult.getData().get(0).getRole().getRoleId());
        if (!roleMenuResult.isSuccess()){
            return CommonResult.fail(roleMenuResult.getReturnCode(),"调用用户角色资源微服务失败");
        }
        List<String> menus = new ArrayList<>();
        for (Menu menu : roleMenuResult.getData().getMenus()){
            if (!menus.contains(menu.getPath()) && !StringUtils.isEmpty(menu.getPath())){
                menus.add(menu.getPath());
            }
        }
        userLoginResult.setMenus(menus);
        userAccessLoginResult.setMenus(roleMenuResultCommonResult.getData());
        userAccessLoginResult.setUserId(teacher.getTeacherId());
        userLoginResult.setTokenValue(teacherId);
        redisTemplate.opsForValue().set(teacherId,token,tokenExpireTime, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set(token,userLoginResult,tokenExpireTime, TimeUnit.MINUTES);

        //判断登录的状态实现单点登录
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        CookieUtil.addCookie(response,cookieDomain,cookiePath,"token",token, cookieTime,true);
        response.setHeader("token",token);
//        CookieUtil.setCookie(response,cookiePath,"token",token, cookieTime);
        userAccessLoginResult.setToken(token);
        return CommonResult.success(userAccessLoginResult);
    }

    /**
     * 普通用户登录
     * @param param
     * @return
     */
    private CommonResult<UserAccessLoginResult> getUserLogin(UserAccessLoginParam param) {
        List<UserResult> userResults = new ArrayList<>();
        if (StringUtils.equals(param.getUserAccountType(), UserAuthConstants.UserLoginType.EMAIL.getCode())){
            if (!RegexUtil.checkEmailPattern(param.getUserAccount())){
                return CommonResult.fail(ExceptionCode.AuthCode.CODE006.code,ExceptionCode.AuthCode.CODE006.message);
            }
            CommonResult<List<UserResult>> userEmailResult  = userControllerClientApi.queryByEmail(param.getUserAccount(),param.getPassword());
            if (!userEmailResult.isSuccess()){
                return CommonResult.fail(userEmailResult.getReturnCode(),"调用用户微服务失败：" + userEmailResult.getReturnMsg());
            }
            if (!CollectionUtils.isEmpty(userEmailResult.getData())){
                userResults.addAll(userEmailResult.getData());
            }

        }else if (StringUtils.equals(param.getUserAccountType(), UserAuthConstants.UserLoginType.MOBILE.getCode())){
            if (!RegexUtil.checkMobilePattern(param.getUserAccount())){
                return CommonResult.fail(ExceptionCode.AuthCode.CODE005.code,ExceptionCode.AuthCode.CODE005.message);
            }
            CommonResult<List<UserResult>> userMobileResult  = userControllerClientApi.queryByMobile(param.getUserAccount(),param.getPassword());
            if (!userMobileResult.isSuccess()){
                return CommonResult.fail(userMobileResult.getReturnCode(),"调用用户微服务失败：" + userMobileResult.getReturnMsg());
            }
            if (!CollectionUtils.isEmpty(userMobileResult.getData())){
                userResults.addAll(userMobileResult.getData());
            }
        }else {
            return CommonResult.fail(ExceptionCode.AuthCode.CODE008.code,ExceptionCode.AuthCode.CODE008.message);
        }

        UserAccessLoginResult userAccessLoginResult = new UserAccessLoginResult();

        String token = UUIDUtils.uuid();
        if (CollectionUtils.isEmpty(userResults)){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE003.code,ExceptionCode.AuthCode.CODE003.message);
        }
        UserResult userResult = userResults.get(0);
        String userId = String.valueOf(userResult.getUserId());

        //先判断用户id是否有过登录状态,执行删除操作
        String tokenValue = (String) redisTemplate.opsForValue().get(userId);
        if (!StringUtils.isEmpty(tokenValue)){
            redisTemplate.delete(tokenValue);
            redisTemplate.delete(userId);
        }
        //重新写入登录状态的信息
        UserLoginResult userLoginResult = new UserLoginResult();
        userLoginResult.setUser(userResult);
        //查询用户权限
        CommonResult<List<UserRoleResult>> userRoleResult = userRoleControllerClientApi.query(userResult.getUserId());
        if (!userRoleResult.isSuccess()){
            return CommonResult.fail(userRoleResult.getReturnCode(),"调用用户角色微服务失败");
        }
        if (CollectionUtils.isEmpty(userRoleResult.getData())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE010.code,ExceptionCode.AuthCode.CODE010.message);
        }
        userLoginResult.setRole(userRoleResult.getData().get(0).getRole());
        userAccessLoginResult.setRoleId(userRoleResult.getData().get(0).getRole().getRoleId());
        CommonResult<List<MenuItem>> roleMenuResultCommonResult = roleMenuControllerClientApi.tree(userRoleResult.getData().get(0).getRole().getRoleId());
        if (!userRoleResult.isSuccess()){
            return CommonResult.fail(userRoleResult.getReturnCode(),"调用用户角色资源微服务失败");
        }
        if (CollectionUtils.isEmpty(roleMenuResultCommonResult.getData())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE011.code,ExceptionCode.AuthCode.CODE011.message);
        }
        //查询用户菜单
        CommonResult<RoleMenuResult> roleMenuResult = roleMenuControllerClientApi.query(userRoleResult.getData().get(0).getRole().getRoleId());
        if (!roleMenuResult.isSuccess()){
            return CommonResult.fail(roleMenuResult.getReturnCode(),"调用用户角色资源微服务失败");
        }
        List<String> menus = new ArrayList<>();
        for (Menu menu : roleMenuResult.getData().getMenus()){
            if (!menus.contains(menu.getPath()) && !StringUtils.isEmpty(menu.getPath())){
                menus.add(menu.getPath());
            }
        }
        userLoginResult.setMenus(menus);
        userAccessLoginResult.setMenus(roleMenuResultCommonResult.getData());
        userAccessLoginResult.setUserId(userResult.getUserId());
        userLoginResult.setTokenValue(userId);
        redisTemplate.opsForValue().set(userId,token,tokenExpireTime, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set(token,userLoginResult,tokenExpireTime, TimeUnit.MINUTES);
        //设置cookie
        //设置redis的token和过期时间
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        CookieUtil.addCookie(response,cookieDomain,cookiePath,"token",token, cookieTime,true);
//        CookieUtil.setCookie(response,cookiePath,"token",token, cookieTime);
        //头部响应token
        response.setHeader("token",token);
        userAccessLoginResult.setToken(token);
        return CommonResult.success(userAccessLoginResult);
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
                teacher.setTeacherName(param.getUsername());
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
    @Transactional
    public CommonResult forgetPassword(UserAccessChangePasswordParam param) {
        //校验输入信息是否正确--正则校验
        if (StringUtils.isEmpty(param.getUserAccount())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE007.code,ExceptionCode.AuthCode.CODE007.message);
        }
        if (StringUtils.isEmpty(param.getUserAccountType())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE008.code,ExceptionCode.AuthCode.CODE008.message);
        }
        if (StringUtils.isEmpty(param.getUserType())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE009.code,ExceptionCode.AuthCode.CODE009.message);
        }
        if (StringUtils.isEmpty(param.getCode())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE013.code,ExceptionCode.AuthCode.CODE013.message);
        }
        if (!UserAuthConstants.UserLoginType.userTypeList().contains(param.getUserAccountType())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE008.code,ExceptionCode.AuthCode.CODE008.message);
        }
        String code = (String) redisTemplate.opsForValue().get(param.getUserAccount());
        if (StringUtils.isEmpty(code)){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE014.code,ExceptionCode.AuthCode.CODE014.message);
        }
        if (!StringUtils.equals(code,param.getCode())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE015.code,ExceptionCode.AuthCode.CODE015.message);
        }

        try {
            if(StringUtils.equals(param.getUserType(),UserAuthConstants.UserLoginAccountType.TEACHER.getCode())){
                User user = new User();

                if (StringUtils.equals(param.getUserAccountType(), UserAuthConstants.UserLoginType.EMAIL.getCode())){
                    CommonResult<List<UserResult>> userResult = userControllerClientApi.queryUserByEmail(param.getUserAccount());
                    if (userResult.isSuccess()){
                        if (CollectionUtils.isEmpty(userResult.getData())){
                            return CommonResult.fail(ExceptionCode.AuthCode.CODE016.code,ExceptionCode.AuthCode.CODE016.message);
                        }
                        BeanCopyUtils.copyProperties(userResult.getData().get(0),user);
                    }
                }else {
                    CommonResult<List<UserResult>> userResult = userControllerClientApi.queryUserByMobile(param.getUserAccount());
                    if (userResult.isSuccess()){
                        if (CollectionUtils.isEmpty(userResult.getData())){
                            return CommonResult.fail(ExceptionCode.AuthCode.CODE016.code,ExceptionCode.AuthCode.CODE016.message);
                        }
                        BeanCopyUtils.copyProperties(userResult.getData().get(0),user);
                    }
                }
                user.setPassword(MD5Util.getStringMD5(param.getPassword()));
                userControllerClientApi.edit(user);
            } else if (StringUtils.equals(param.getUserType(),UserAuthConstants.UserLoginAccountType.USER.getCode())) {
                Teacher teacher = new Teacher();
                if (StringUtils.equals(param.getUserAccountType(), UserAuthConstants.UserLoginType.EMAIL.getCode())){
                    CommonResult<List<TeacherResult>> teacherResult = teacherControllerClientApi.queryTeacherByEmail(param.getUserAccount());
                    if (teacherResult.isSuccess()){
                        if (CollectionUtils.isEmpty(teacherResult.getData())){
                            return CommonResult.fail(ExceptionCode.AuthCode.CODE016.code,ExceptionCode.AuthCode.CODE016.message);
                        }
                    }
                    BeanCopyUtils.copyProperties(teacherResult.getData().get(0),teacher);
                }else {
                    CommonResult<List<TeacherResult>> teacherResult = teacherControllerClientApi.queryTeacherByMobile(param.getUserAccount());
                    if (teacherResult.isSuccess()){
                        if (CollectionUtils.isEmpty(teacherResult.getData())){
                            return CommonResult.fail(ExceptionCode.AuthCode.CODE016.code,ExceptionCode.AuthCode.CODE016.message);
                        }
                    }
                    BeanCopyUtils.copyProperties(teacherResult.getData().get(0),teacher);
                }
                teacher.setPassword(MD5Util.getStringMD5(param.getPassword()));
                teacherControllerClientApi.edit(teacher);
            }

            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE017.code,ExceptionCode.AuthCode.CODE017.message);
        }
    }

    @Override
    @Transactional
    public CommonResult getCode(UserAccessCodeParam param) {
        if (StringUtils.isEmpty(param.getUserAccount())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE007.code,ExceptionCode.AuthCode.CODE007.message);
        }
        if (StringUtils.isEmpty(param.getUserAccount())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE007.code,ExceptionCode.AuthCode.CODE007.message);
        }
        //检验账号
        if (!RegexUtil.checkEmailPattern(param.getUserAccount()) && !RegexUtil.checkMobilePattern(param.getUserAccount())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE012.code,ExceptionCode.AuthCode.CODE012.message);
        }
        if (!UserAuthConstants.UserLoginAccountType.userTypeList().contains(param.getUserType())){
            return CommonResult.fail(ExceptionCode.AuthCode.CODE008.code,ExceptionCode.AuthCode.CODE008.message);
        }
        String code = RandomUtil.getRandom(6);
        String value = (String) redisTemplate.opsForValue().get(param.getUserAccount());
        if (StringUtils.isEmpty(value)){
            redisTemplate.opsForValue().set(param.getUserAccount(),code,codeExpireTime,TimeUnit.MINUTES);
        }else {
            return CommonResult.success(value);
        }
        //发送短信或者发送邮件验证码
        return CommonResult.success(code);
    }
}

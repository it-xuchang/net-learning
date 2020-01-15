package com.netlearning.govern.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.auth.result.UserLoginResult;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.CookieUtil;
import com.netlearning.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/12 11:04
 */
@Component
public class ZuulGlobalFilter extends ZuulFilter {

    @Value("${tokenName}")
    private String tokenName;
    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${tokenExpireTime}")
    private Long tokenExpireTime;
    @Value("${cookieDomain}")
    private String cookieDomain;
    @Value("${cookiePath}")
    private String cookiePath;
    @Value("${cookieTime}")
    private int cookieTime;
    //非拦截地址
    private List<String> paths;

    public ZuulGlobalFilter() {
        paths = new ArrayList<>();
        paths.add("/ams/user/access/login");
        paths.add("/ams/user/access/register");
        paths.add("/ams/user/access/change/password");
        paths.add("/ui/**");
        paths.add("/**/swagger**/**");
        paths.add("/**/v2/api-docs");
        paths.add("/**/*.css");
        paths.add("/**/*.jpg");
        paths.add("/**/*.png");
        paths.add("/**/*.gif");
        paths.add("/**/*.js");
        paths.add("/**/*.svg");
    }

    /**过虑器的类型
     *  pre：请求在被路由之前执行
     *  routing：在路由请求时调用
     *  post：在routing和errror过滤器之后调用
     *  error：处理请求时发生错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    //过虑器序号，越小越被优先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //返回true表示要执行此过虑器
        if (checkUrl()){
            return false;
        }
        return true;
    }

    /**
     * 拦截的路径
     * @return
     */
    private boolean checkUrl(){
        String uri=this.getUrl();
        PathMatcher matcher = new AntPathMatcher();
        Optional<String> optional =paths.stream().filter(t->matcher.match(t,uri)).findFirst();
        return optional.isPresent();
    }
    private String getUrl(){
        RequestContext requestContext= RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();
        String uri=request.getRequestURI();
        return uri;
    }

    //过虑器的内容
    //测试的需求：过虑所有请求，判断头部信息是否有名称为token的cookie，如果没有则拒绝访问，否则转发到微服务。
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        //得到request
        HttpServletRequest request = currentContext.getRequest();
        //得到response
        HttpServletResponse response = currentContext.getResponse();
        //取cookie中的身份令牌
        String token = CookieUtil.getCookie(request.getCookies(),tokenName);

        if (StringUtils.isEmpty(token)) {
            this.accessDenied(currentContext,response);
            return null;
        }
        //判断token是否存在redis中
        UserLoginResult userLoginResult = (UserLoginResult) redisTemplate.opsForValue().get(token);
        if (userLoginResult == null){
            this.accessDenied(currentContext,response);
            return null;
        }
        //用户是否该接口访问的权限
        if (CollectionUtils.isEmpty(userLoginResult.getMenus())){
            permissionDenied(currentContext,response);
            return null;
        }else {
            List<String> menus = userLoginResult.getMenus();
            String uri=this.getUrl();
            if (!menus.contains(uri)){
                permissionDenied(currentContext,response);
                return null;
            }
        }
        String tokenValue = userLoginResult.getTokenValue();
        //更新redis的过期时间
        redisTemplate.expire(token,tokenExpireTime, TimeUnit.MINUTES);
        redisTemplate.expire(tokenValue,tokenExpireTime, TimeUnit.MINUTES);
        //重新更新cookie
        CookieUtil.updateCookie(request,response,cookieDomain,cookiePath,tokenName,token, cookieTime,true);
        return null;
    }

    /**
     * 拒绝访问
     * 设置拒接的状态
     * @param currentContext
     * @param response
     */
    private void accessDenied(RequestContext currentContext,HttpServletResponse response){

        //拒绝访问
        currentContext.setSendZuulResponse(false);
        //设置响应代码
        currentContext.setResponseStatusCode(401);
        //构建响应的信息
        CommonResult commonResult = CommonResult.fail("401","请求超时，请重新登录");
        //转成json
        String jsonString = JSON.toJSONString(commonResult);
        currentContext.setResponseBody(jsonString);
        //转成json，设置contentType
        response.setContentType("application/json;charset=utf-8");
    }

    /**
     * 权限不足
     * @param currentContext
     * @param response
     */
    private void permissionDenied(RequestContext currentContext,HttpServletResponse response){

        //拒绝访问
        currentContext.setSendZuulResponse(false);
        //设置响应代码
        currentContext.setResponseStatusCode(403);
        //构建响应的信息
        CommonResult commonResult = CommonResult.fail("403","用户权限不足");
        //转成json
        String jsonString = JSON.toJSONString(commonResult);
        currentContext.setResponseBody(jsonString);
        //转成json，设置contentType
        response.setContentType("application/json;charset=utf-8");
    }


}


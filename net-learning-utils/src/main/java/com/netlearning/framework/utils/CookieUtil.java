package com.netlearning.framework.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 */
public class CookieUtil {

    /**
     * 设置cookie
     *
     * @param response
     * @param name     cookie名字
     * @param value    cookie值
     * @param maxAge   cookie生命周期 以秒为单位
     */
    public static void addCookie(HttpServletResponse response,String domain,String path, String name,
                                 String value, int maxAge,boolean httpOnly) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(domain);
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(httpOnly);
        response.addCookie(cookie);
    }

    public static void updateCookie(HttpServletRequest request,HttpServletResponse response,String domain,String path, String name,
                                 String value, int maxAge,boolean httpOnly) {
        deleteCookie(request.getCookies(),name);
        addCookie(response,domain,path,name,value,maxAge,httpOnly);
    }



    /**
     * 根据cookie名称读取cookie
     * @param request
     * @return map<cookieName,cookieValue>
     */

    public static Map<String,String> readCookie(HttpServletRequest request,String ... cookieNames) {
        Map<String,String> cookieMap = new HashMap<String,String>();
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String cookieName = cookie.getName();
                    String cookieValue = cookie.getValue();
                    for(int i=0;i<cookieNames.length;i++){
                        if(cookieNames[i].equals(cookieName)){
                            cookieMap.put(cookieName,cookieValue);
                        }
                    }
                }
            }
        return cookieMap;

    }

    /**
     * 获取cookie的属性值
     * @param cookies
     * @param name
     * @return
     */
    public static String getCookie(Cookie[] cookies,String name) {

        String token = null;
        if (cookies != null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (StringUtils.equals(cookieName,name)){
                    token = cookie.getValue();
                }
            }
        }
        return token;
    }
    public static void deleteCookie(Cookie[] cookies,String name) {

        if (cookies != null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (StringUtils.equals(cookieName,name)){
                    cookie.setMaxAge(-1);
                }
            }
        }
    }
}

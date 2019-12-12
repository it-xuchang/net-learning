package com.netlearning.govern.gateway.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/12 11:05
 */
public interface AuthService {
    String getTokenFromCookie(HttpServletRequest request);

    String getJwtFromHeader(HttpServletRequest request);

    long getExpire(String tokenFromCookie);
}

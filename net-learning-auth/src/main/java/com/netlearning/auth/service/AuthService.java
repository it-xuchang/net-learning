package com.netlearning.auth.service;

import com.netlearning.framework.domain.ucenter.ext.AuthToken;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 14:27
 */
public interface AuthService {
    AuthToken login(String username, String password, String clientId, String clientSecret);

    boolean delToken(String uid);

    AuthToken getUserToken(String uid);
}

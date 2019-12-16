package com.netlearning.ucenter.service;

import com.netlearning.framework.domain.ucenter.ext.UserExt;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 11:47
 */
public interface UserService {
    UserExt getUserExt(String username);
}

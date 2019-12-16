package com.netlearning.ucenter.dao;

import com.netlearning.framework.domain.ucenter.User;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 11:45
 */
public interface UserRepository {
    //根据账号查询用户信息
    User findByUsername(String username);
}

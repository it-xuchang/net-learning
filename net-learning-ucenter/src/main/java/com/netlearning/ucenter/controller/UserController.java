package com.netlearning.ucenter.controller;

import com.netlearning.api.ucenter.UserControllerApi;
import com.netlearning.framework.domain.ucenter.ext.UserExt;
import com.netlearning.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 11:51
 */
public class UserController implements UserControllerApi {

    @Autowired
    UserService userService;

    @Override
    @GetMapping("/getuserext")
    public UserExt getUserext(@RequestParam("username") String username) {
        return userService.getUserExt(username);
    }
}

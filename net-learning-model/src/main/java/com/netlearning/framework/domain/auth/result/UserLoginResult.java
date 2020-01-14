package com.netlearning.framework.domain.auth.result;

import com.netlearning.framework.domain.userAuth.Menu;
import com.netlearning.framework.domain.userAuth.Role;
import com.netlearning.framework.domain.userAuth.result.TeacherResult;
import com.netlearning.framework.domain.userAuth.result.UserResult;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/11 14:22
 */
@Data
public class UserLoginResult {
    private String tokenValue;
    private TeacherResult teacher;
    private UserResult user;
    private Role role;
    private List<Menu> menus;
}

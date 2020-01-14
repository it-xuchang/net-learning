package com.netlearning.framework.domain.auth.result;

import com.netlearning.framework.domain.userAuth.Menu;
import lombok.Data;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/11 14:22
 */
@Data
public class UserAccessLoginResult {
    private Long userId;
    private Long roleId;
    private List<Menu> menus;
}

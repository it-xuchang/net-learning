package com.netlearning.framework.domain.auth.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.netlearning.framework.domain.userAuth.Menu;
import com.netlearning.framework.domain.userAuth.MenuItem;
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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;
    private List<MenuItem> menus;
    private String token;
}

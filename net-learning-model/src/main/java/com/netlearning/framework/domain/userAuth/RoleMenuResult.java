package com.netlearning.framework.domain.userAuth;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;
@Data
public class RoleMenuResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    private List<Menu> menus;
}

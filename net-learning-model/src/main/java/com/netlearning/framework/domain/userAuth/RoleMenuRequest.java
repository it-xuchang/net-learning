package com.netlearning.framework.domain.userAuth;

import lombok.Data;

import java.util.List;

@Data
public class RoleMenuRequest {
    private Long roleId;

    private List<Long> menuIds;

}

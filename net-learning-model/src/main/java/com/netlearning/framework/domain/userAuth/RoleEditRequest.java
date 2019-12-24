package com.netlearning.framework.domain.userAuth;

import lombok.Data;

import java.util.List;

@Data
public class RoleEditRequest {

    private Long roleId;

    private String roleName;

    private String remark;

    private List<Long> menuIds;

}

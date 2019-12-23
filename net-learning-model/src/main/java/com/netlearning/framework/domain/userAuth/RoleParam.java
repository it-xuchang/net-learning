package com.netlearning.framework.domain.userAuth;

import lombok.Data;

import java.util.Date;

@Data
public class RoleParam {
    private Long roleId;

    private String roleName;

    private String remark;

    private String startCreateTime;

    private String endCreateTime;

}

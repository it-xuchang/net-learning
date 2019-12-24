package com.netlearning.framework.domain.userAuth;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RoleAddRequest {

    private String roleName;
    private String remark;
    private List<Long> menuIds;

}

package com.netlearning.framework.domain.userAuth;

import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/22 15:01
 */
@Data
public class RoleTreeParam {
    private Long roleId;
    private Long menuParentId;
}

package com.netlearning.framework.domain.userAuth;

import lombok.Data;

@Data
public class RoleMenuParam {
    private Long roleId;

    private Long menuId;

    /**
     * 当前页号
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;
}

package com.netlearning.framework.domain.userAuth;

import lombok.Data;

import java.util.Date;
/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:44
 */
@Data
public class MenuParam {
    private Long menuId;

    private Long parentId;

    private String menuName;

    private String path;

    private String component;

    private String perms;

    private String icon;

    private String type;

    private String startCreateTime;

    private String endCreateTime;


}

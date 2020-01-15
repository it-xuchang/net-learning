package com.netlearning.framework.domain.userAuth.param;


import lombok.Data;


@Data
public class MenuAddParam {
    private Long parentId;

    private String menuName;

    private String path;

    private String component;

    private String perms;

    private String icon;

    private String type;

    private Double orderNum;


}

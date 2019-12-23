package com.netlearning.framework.domain.userAuth;

import lombok.Data;

@Data
public class UserConfigParam {
    private Long userId;

    private String theme;

    private String layout;

    private String multiPage;

    private String fixSiderbar;

    private String fixHeader;

    private String color;

}

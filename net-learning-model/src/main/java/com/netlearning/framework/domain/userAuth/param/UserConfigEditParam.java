package com.netlearning.framework.domain.userAuth.param;

import lombok.Data;

@Data
public class UserConfigEditParam {
    private Long userId;

    private String theme;

    private String layout;

    private String multiPage;

    private String fixSiderbar;

    private String fixHeader;

    private String color;

}

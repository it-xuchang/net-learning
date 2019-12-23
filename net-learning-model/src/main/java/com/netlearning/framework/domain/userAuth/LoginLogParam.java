package com.netlearning.framework.domain.userAuth;

import lombok.Data;

import java.util.Date;
@Data
public class LoginLogParam {
    private String username;

    private String startLoginTime;

    private String endLoginTime;

    private String location;

    private String ip;

}

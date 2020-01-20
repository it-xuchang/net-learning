package com.netlearning.framework.domain.userAuth.param;

import lombok.Data;

import java.util.Date;

@Data
public class LoginLogAddParam {

    private String username;

    private Date loginTime;

    private String location;

    private String ip;

}

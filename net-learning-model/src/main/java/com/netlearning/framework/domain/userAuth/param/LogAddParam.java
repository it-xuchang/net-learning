package com.netlearning.framework.domain.userAuth.param;

import lombok.Data;

@Data
public class LogAddParam {

    private String username;

    private Long time;

    private String ip;

    private String location;

}

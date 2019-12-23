package com.netlearning.framework.domain.userAuth;


import lombok.Data;

import java.util.Date;
@Data
public class LogParam {
    private Long id;

    private String username;

    private Long time;

    private String ip;

    private String startCreateTime;

    private String endCreateTime;

    private String location;


}

package com.netlearning.framework.domain.userAuth.param;


import lombok.Data;


@Data
public class LogEditParam {
    private Long id;

    private String username;

    private Long time;

    private String ip;

    private String location;
}

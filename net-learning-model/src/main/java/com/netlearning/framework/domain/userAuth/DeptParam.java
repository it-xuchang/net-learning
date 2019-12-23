package com.netlearning.framework.domain.userAuth;

import lombok.Data;

import java.util.Date;

@Data
public class DeptParam {
    private Long deptId;

    private Long parentId;

    private String deptName;

    private String startCreateTime;

    private String endCreateTime;

}

package com.netlearning.framework.domain.userAuth.param;

import lombok.Data;

@Data
public class DeptAddParam {

    private Long parentId;

    private String deptName;

    private Double orderNum;

}

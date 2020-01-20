package com.netlearning.framework.domain.userAuth.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;
@Data
public class DeptEditParam {
    private Long deptId;

    private Long parentId;

    private String deptName;

    private Double orderNum;

}

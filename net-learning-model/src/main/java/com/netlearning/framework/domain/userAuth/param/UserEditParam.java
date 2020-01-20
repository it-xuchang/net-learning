package com.netlearning.framework.domain.userAuth.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:44
 */
@Data
public class UserEditParam {
    private Long userId;

    private String username;

    private Long deptId;

    private String email;

    private String mobile;

    private String status;

    private String sex;

    private String description;

    private String avatar;

}

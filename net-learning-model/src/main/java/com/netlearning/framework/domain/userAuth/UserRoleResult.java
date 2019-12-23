package com.netlearning.framework.domain.userAuth;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class UserRoleResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private Role role;

}

package com.netlearning.framework.domain.userAuth;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class UserRole {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}

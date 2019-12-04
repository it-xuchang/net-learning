package com.netlearning.framework.context;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

public class UserContext implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1937298343860044405L;

    /**
     * 调用者信息
     */
    @NotNull(message = "10000013")
    private String caller;

    /**
     * 姓名
     */
    private String callerName;

    /**
     * 用户角色
     */
    private Set<String> roles;

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}

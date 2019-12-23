package com.netlearning.framework.domain.userAuth;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RoleTreeMenu<T> {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long menuId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    private String menuName;

    private String path;

    private String component;

    private String perms;

    private String icon;

    private String type;

    private Double orderNum;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date modifyTime;

    private List<RoleTreeMenu<T>> children;

    public void initChildren(){
        this.children = new ArrayList<>();
    }
}

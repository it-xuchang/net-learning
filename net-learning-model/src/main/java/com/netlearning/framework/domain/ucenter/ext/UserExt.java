package com.netlearning.framework.domain.ucenter.ext;

import com.netlearning.framework.domain.ucenter.Menu;
import com.netlearning.framework.domain.ucenter.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserExt extends User {

    //权限信息
    private List<Menu> permissions;

    //企业信息
    private String companyId;
}

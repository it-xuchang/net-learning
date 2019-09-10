package com.netlearning.framework.domain.ucenter.ext;

import com.netlearning.framework.domain.ucenter.NetLearningMenu;
import com.netlearning.framework.domain.ucenter.NetLearningUser;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class NetLearningUserExt extends NetLearningUser {

    //权限信息
    private List<NetLearningMenu> permissions;

    //企业信息
    private String companyId;
}

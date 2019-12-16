package com.netlearning.ucenter.dao;

import com.netlearning.framework.domain.ucenter.Menu;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 11:38
 */
public interface MenuMapper {
    //根据用户id查询用户的权限
    public List<Menu> selectPermissionByUserId(String userid);
}

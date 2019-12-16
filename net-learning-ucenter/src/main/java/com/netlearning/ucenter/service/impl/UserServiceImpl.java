package com.netlearning.ucenter.service.impl;


import com.netlearning.framework.domain.ucenter.CompanyUser;
import com.netlearning.framework.domain.ucenter.Menu;
import com.netlearning.framework.domain.ucenter.User;
import com.netlearning.framework.domain.ucenter.ext.UserExt;
import com.netlearning.ucenter.dao.CompanyUserRepository;
import com.netlearning.ucenter.dao.MenuMapper;
import com.netlearning.ucenter.dao.UserRepository;
import com.netlearning.ucenter.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 11:47
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserExt getUserExt(String username) {
        //根据账号查询xcUser信息
        User user = this.findXcUserByUsername(username);
        if(user == null){
            return null;
        }
        //用户id
        String userId = user.getId();
        //查询用户所有权限
        List<Menu> menus = menuMapper.selectPermissionByUserId(userId);

        //根据用户id查询用户所属公司id
        CompanyUser companyUser = companyUserRepository.findByUserId(userId);
        //取到用户的公司id
        String companyId = null;
        if(companyUser!=null){
            companyId = companyUser.getCompanyId();
        }
        UserExt userExt = new UserExt();
        BeanUtils.copyProperties(user,userExt);
        userExt.setCompanyId(companyId);
        //设置权限
        userExt.setPermissions(menus);
        return userExt;
    }
    //根据账号查询xcUser信息
    public User findXcUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}

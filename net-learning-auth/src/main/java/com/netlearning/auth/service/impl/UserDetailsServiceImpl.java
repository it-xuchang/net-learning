package com.netlearning.auth.service.impl;

import com.netlearning.auth.client.UserClient;
import com.netlearning.auth.pojo.UserJwt;
import com.netlearning.framework.domain.ucenter.Menu;
import com.netlearning.framework.domain.ucenter.ext.UserExt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 14:30
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserClient userClient;

    @Autowired
    ClientDetailsService clientDetailsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if(authentication==null){
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
            if(clientDetails!=null){
                //密码
                String clientSecret = clientDetails.getClientSecret();
                return new User(username,clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        //远程调用用户中心根据账号查询用户信息
        UserExt userext = userClient.getUserext(username);
        if(userext == null){
            //返回空给spring security表示用户不存在
            return null;
        }

        //取出正确密码（hash值）
        String password = userext.getPassword();
        //这里暂时使用静态密码
        //用户权限，这里暂时使用静态数据，最终会从数据库读取
        //从数据库获取权限
        List<Menu> permissions = userext.getPermissions();
        if(permissions == null){
            permissions = new ArrayList<>();
        }
        List<String> userPermission = new ArrayList<>();
        permissions.forEach(item-> userPermission.add(item.getCode()));

        String userPermissionString  = StringUtils.join(userPermission.toArray(), ",");
        UserJwt userDetails = new UserJwt(username,
                password,
                AuthorityUtils.commaSeparatedStringToAuthorityList(userPermissionString));
        userDetails.setId(userext.getId());
        userDetails.setUtype(userext.getUtype());//用户类型
        userDetails.setCompanyId(userext.getCompanyId());//所属企业
        userDetails.setName(userext.getName());//用户名称
        userDetails.setUserpic(userext.getUserpic());//用户头像
        return userDetails;
    }
}

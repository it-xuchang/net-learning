package com.netlearning.ucenter.dao;

import com.netlearning.framework.domain.ucenter.CompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/16 11:46
 */
public interface CompanyUserRepository extends JpaRepository<CompanyUser,String> {
    //根据用户id查询该用户所属的公司id
    CompanyUser findByUserId(String userId);
}

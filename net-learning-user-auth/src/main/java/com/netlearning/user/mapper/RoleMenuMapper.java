package com.netlearning.user.mapper;

import com.netlearning.framework.domain.userAuth.RoleMenu;
import com.netlearning.framework.domain.userAuth.RoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuMapper {
    long countByExample(RoleMenuExample example);

    int deleteByExample(RoleMenuExample example);

    int insert(RoleMenu record);

    int mutipartInsertSelective(@Param("records") List<RoleMenu> records);

    int insertSelective(RoleMenu record);

    List<RoleMenu> selectByExample(RoleMenuExample example);

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);
}

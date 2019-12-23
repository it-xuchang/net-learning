package com.netlearning.user.mapper;

import com.netlearning.framework.domain.userAuth.LoginLog;
import com.netlearning.framework.domain.userAuth.LoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogMapper {
    long countByExample(LoginLogExample example);

    int deleteByExample(LoginLogExample example);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    List<LoginLog> selectByExample(LoginLogExample example);

    int updateByExampleSelective(@Param("record") LoginLog record, @Param("example") LoginLogExample example);

    int updateByExample(@Param("record") LoginLog record, @Param("example") LoginLogExample example);
}

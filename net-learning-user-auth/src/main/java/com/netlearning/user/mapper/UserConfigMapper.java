package com.netlearning.user.mapper;

import com.netlearning.framework.domain.userAuth.UserConfig;
import com.netlearning.framework.domain.userAuth.UserConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserConfigMapper {
    long countByExample(UserConfigExample example);

    int deleteByExample(UserConfigExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(UserConfig record);

    int insertSelective(UserConfig record);

    List<UserConfig> selectByExample(UserConfigExample example);

    UserConfig selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UserConfig record, @Param("example") UserConfigExample example);

    int updateByExample(@Param("record") UserConfig record, @Param("example") UserConfigExample example);

    int updateByPrimaryKeySelective(UserConfig record);

    int updateByPrimaryKey(UserConfig record);
}

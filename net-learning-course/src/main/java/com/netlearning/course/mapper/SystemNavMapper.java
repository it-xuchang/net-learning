package com.netlearning.course.mapper;

import com.netlearning.framework.domain.course.SystemNav;
import com.netlearning.framework.domain.course.SystemNavExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemNavMapper {
    long countByExample(SystemNavExample example);

    int deleteByExample(SystemNavExample example);

    int deleteByPrimaryKey(Long systemNavId);

    int insert(SystemNav record);

    int insertSelective(SystemNav record);

    List<SystemNav> selectByExample(SystemNavExample example);

    SystemNav selectByPrimaryKey(Long systemNavId);

    int updateByExampleSelective(@Param("record") SystemNav record, @Param("example") SystemNavExample example);

    int updateByExample(@Param("record") SystemNav record, @Param("example") SystemNavExample example);

    int updateByPrimaryKeySelective(SystemNav record);

    int updateByPrimaryKey(SystemNav record);
}

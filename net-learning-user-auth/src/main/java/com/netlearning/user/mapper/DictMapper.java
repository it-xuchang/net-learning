package com.netlearning.user.mapper;

import com.netlearning.framework.domain.userAuth.Dict;
import com.netlearning.framework.domain.userAuth.DictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictMapper {
    long countByExample(DictExample example);

    int deleteByExample(DictExample example);

    int deleteByPrimaryKey(Long dictId);

    int insert(Dict record);

    int insertSelective(Dict record);

    List<Dict> selectByExample(DictExample example);

    Dict selectByPrimaryKey(Long dictId);

    int updateByExampleSelective(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);
}

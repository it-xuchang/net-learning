package com.netlearning.course.mapper;

import com.netlearning.framework.domain.course.TeachPlanMedia;
import com.netlearning.framework.domain.course.TeachPlanMediaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeachPlanMediaMapper {
    long countByExample(TeachPlanMediaExample example);

    int deleteByExample(TeachPlanMediaExample example);

    int deleteByPrimaryKey(Long teachplanMediaId);

    int insert(TeachPlanMedia record);

    int insertSelective(TeachPlanMedia record);

    List<TeachPlanMedia> selectByExample(TeachPlanMediaExample example);

    TeachPlanMedia selectByPrimaryKey(Long teachplanMediaId);

    int updateByExampleSelective(@Param("record") TeachPlanMedia record, @Param("example") TeachPlanMediaExample example);

    int updateByExample(@Param("record") TeachPlanMedia record, @Param("example") TeachPlanMediaExample example);

    int updateByPrimaryKeySelective(TeachPlanMedia record);

    int updateByPrimaryKey(TeachPlanMedia record);
}

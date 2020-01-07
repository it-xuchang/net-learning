package com.netlearning.course.mapper;

import com.netlearning.framework.domain.course.TeachPlan;
import com.netlearning.framework.domain.course.TeachPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeachPlanMapper {
    long countByExample(TeachPlanExample example);

    int deleteByExample(TeachPlanExample example);

    int deleteByPrimaryKey(Long teachplanId);

    int insert(TeachPlan record);

    int insertSelective(TeachPlan record);

    List<TeachPlan> selectByExample(TeachPlanExample example);

    TeachPlan selectByPrimaryKey(Long teachplanId);

    int updateByExampleSelective(@Param("record") TeachPlan record, @Param("example") TeachPlanExample example);

    int updateByExample(@Param("record") TeachPlan record, @Param("example") TeachPlanExample example);

    int updateByPrimaryKeySelective(TeachPlan record);

    int updateByPrimaryKey(TeachPlan record);
}

package com.netlearning.course.mapper;

import com.netlearning.framework.domain.course.TeachPlanMediaTencent;
import com.netlearning.framework.domain.course.TeachPlanMediaTencentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeachPlanMediaTencentMapper {
    long countByExample(TeachPlanMediaTencentExample example);

    int deleteByExample(TeachPlanMediaTencentExample example);

    int deleteByPrimaryKey(Long teachplanMediaTencentId);

    int insert(TeachPlanMediaTencent record);

    int insertSelective(TeachPlanMediaTencent record);

    List<TeachPlanMediaTencent> selectByExample(TeachPlanMediaTencentExample example);

    TeachPlanMediaTencent selectByPrimaryKey(Long teachplanMediaTencentId);

    int updateByExampleSelective(@Param("record") TeachPlanMediaTencent record, @Param("example") TeachPlanMediaTencentExample example);

    int updateByExample(@Param("record") TeachPlanMediaTencent record, @Param("example") TeachPlanMediaTencentExample example);

    int updateByPrimaryKeySelective(TeachPlanMediaTencent record);

    int updateByPrimaryKey(TeachPlanMediaTencent record);
}

package com.netlearning.course.mapper;

import com.netlearning.framework.domain.course.CourseBase;
import com.netlearning.framework.domain.course.CourseBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseBaseMapper {
    long countByExample(CourseBaseExample example);

    int deleteByExample(CourseBaseExample example);

    int deleteByPrimaryKey(Long courseId);

    int insert(CourseBase record);

    int insertSelective(CourseBase record);

    List<CourseBase> selectByExampleWithBLOBs(CourseBaseExample example);

    List<CourseBase> selectByExample(CourseBaseExample example);

    CourseBase selectByPrimaryKey(Long courseId);

    int updateByExampleSelective(@Param("record") CourseBase record, @Param("example") CourseBaseExample example);

    int updateByExampleWithBLOBs(@Param("record") CourseBase record, @Param("example") CourseBaseExample example);

    int updateByExample(@Param("record") CourseBase record, @Param("example") CourseBaseExample example);

    int updateByPrimaryKeySelective(CourseBase record);

    int updateByPrimaryKeyWithBLOBs(CourseBase record);

    int updateByPrimaryKey(CourseBase record);
}

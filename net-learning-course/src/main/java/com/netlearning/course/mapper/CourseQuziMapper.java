package com.netlearning.course.mapper;

import com.netlearning.framework.domain.course.CourseQuzi;
import com.netlearning.framework.domain.course.CourseQuziExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseQuziMapper {
    long countByExample(CourseQuziExample example);

    int deleteByExample(CourseQuziExample example);

    int deleteByPrimaryKey(Long courseQuziId);

    int insert(CourseQuzi record);

    int insertSelective(CourseQuzi record);

    List<CourseQuzi> selectByExample(CourseQuziExample example);

    CourseQuzi selectByPrimaryKey(Long courseQuziId);

    int updateByExampleSelective(@Param("record") CourseQuzi record, @Param("example") CourseQuziExample example);

    int updateByExample(@Param("record") CourseQuzi record, @Param("example") CourseQuziExample example);

    int updateByPrimaryKeySelective(CourseQuzi record);

    int updateByPrimaryKey(CourseQuzi record);
}

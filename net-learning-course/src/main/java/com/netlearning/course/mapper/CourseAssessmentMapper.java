package com.netlearning.course.mapper;

import com.netlearning.framework.domain.course.CourseAssessment;
import com.netlearning.framework.domain.course.CourseAssessmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseAssessmentMapper {
    long countByExample(CourseAssessmentExample example);

    int deleteByExample(CourseAssessmentExample example);

    int deleteByPrimaryKey(Long courseAssessmentId);

    int insert(CourseAssessment record);

    int insertSelective(CourseAssessment record);

    List<CourseAssessment> selectByExample(CourseAssessmentExample example);

    CourseAssessment selectByPrimaryKey(Long courseAssessmentId);

    int updateByExampleSelective(@Param("record") CourseAssessment record, @Param("example") CourseAssessmentExample example);

    int updateByExample(@Param("record") CourseAssessment record, @Param("example") CourseAssessmentExample example);

    int updateByPrimaryKeySelective(CourseAssessment record);

    int updateByPrimaryKey(CourseAssessment record);
}

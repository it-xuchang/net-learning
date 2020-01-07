package com.netlearning.course.mapper;

import com.netlearning.framework.domain.course.CourseRecommendation;
import com.netlearning.framework.domain.course.LearningCourse;
import com.netlearning.framework.domain.course.LearningCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LearningCourseMapper {
    long countByExample(LearningCourseExample example);

    int deleteByExample(LearningCourseExample example);

    int deleteByPrimaryKey(Long learningId);

    int insert(LearningCourse record);

    int insertSelective(LearningCourse record);

    List<LearningCourse> selectByExample(LearningCourseExample example);

    LearningCourse selectByPrimaryKey(Long learningId);

    int updateByExampleSelective(@Param("record") LearningCourse record, @Param("example") LearningCourseExample example);

    int updateByExample(@Param("record") LearningCourse record, @Param("example") LearningCourseExample example);

    int updateByPrimaryKeySelective(LearningCourse record);

    int updateByPrimaryKey(LearningCourse record);

    List<CourseRecommendation> countCourseByHotSize(@Param("courseIds") List<Long> courseIds);
}

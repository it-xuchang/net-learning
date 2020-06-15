package com.netlearning.course.mapper;

import com.netlearning.framework.domain.course.LearningTeachplan;
import com.netlearning.framework.domain.course.LearningTeachplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LearningTeachplanMapper {
    long countByExample(LearningTeachplanExample example);

    int deleteByExample(LearningTeachplanExample example);

    int deleteByPrimaryKey(Long learningTeachplanId);

    int insert(LearningTeachplan record);

    int insertSelective(LearningTeachplan record);

    List<LearningTeachplan> selectByExample(LearningTeachplanExample example);

    LearningTeachplan selectByPrimaryKey(Long learningTeachplanId);

    int updateByExampleSelective(@Param("record") LearningTeachplan record, @Param("example") LearningTeachplanExample example);

    int updateByExample(@Param("record") LearningTeachplan record, @Param("example") LearningTeachplanExample example);

    int updateByPrimaryKeySelective(LearningTeachplan record);

    int multipartUpdateByPrimaryKey(@Param("records") List<LearningTeachplan> records);

    int updateByPrimaryKey(LearningTeachplan record);
}

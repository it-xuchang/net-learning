package com.netlearning.course.mapper;

import com.netlearning.framework.domain.course.FrequentlyAskedQuestion;
import com.netlearning.framework.domain.course.FrequentlyAskedQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FrequentlyAskedQuestionMapper {
    long countByExample(FrequentlyAskedQuestionExample example);

    int deleteByExample(FrequentlyAskedQuestionExample example);

    int deleteByPrimaryKey(Long frequentlyAskedQuestionId);

    int insert(FrequentlyAskedQuestion record);

    int insertSelective(FrequentlyAskedQuestion record);

    List<FrequentlyAskedQuestion> selectByExample(FrequentlyAskedQuestionExample example);

    FrequentlyAskedQuestion selectByPrimaryKey(Long frequentlyAskedQuestionId);

    int updateByExampleSelective(@Param("record") FrequentlyAskedQuestion record, @Param("example") FrequentlyAskedQuestionExample example);

    int updateByExample(@Param("record") FrequentlyAskedQuestion record, @Param("example") FrequentlyAskedQuestionExample example);

    int updateByPrimaryKeySelective(FrequentlyAskedQuestion record);

    int updateByPrimaryKey(FrequentlyAskedQuestion record);
}

package com.netlearning.course.mapper;

import com.netlearning.framework.domain.course.CourseFavorite;
import com.netlearning.framework.domain.course.CourseFavoriteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseFavoriteMapper {
    long countByExample(CourseFavoriteExample example);

    int deleteByExample(CourseFavoriteExample example);

    int deleteByPrimaryKey(Long courseFavoriteId);

    int insert(CourseFavorite record);

    int insertSelective(CourseFavorite record);

    List<CourseFavorite> selectByExample(CourseFavoriteExample example);

    CourseFavorite selectByPrimaryKey(Long courseFavoriteId);

    int updateByExampleSelective(@Param("record") CourseFavorite record, @Param("example") CourseFavoriteExample example);

    int updateByExample(@Param("record") CourseFavorite record, @Param("example") CourseFavoriteExample example);

    int updateByPrimaryKeySelective(CourseFavorite record);

    int updateByPrimaryKey(CourseFavorite record);
}

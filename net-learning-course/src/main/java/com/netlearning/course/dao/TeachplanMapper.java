package com.netlearning.course.dao;
import org.apache.ibatis.annotations.Mapper;

import com.netlearning.framework.domain.course.ext.TeachplanNode;


/**
 * @author No
 *持久层使用mybatis
 */
@Mapper
public interface TeachplanMapper {
    //课程计划查询
    public TeachplanNode selectList(String courseId);
}
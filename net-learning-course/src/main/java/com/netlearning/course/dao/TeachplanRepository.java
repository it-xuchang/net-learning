package com.netlearning.course.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netlearning.framework.domain.course.Teachplan;

/**
 * @author No
 *持久层使用springdata jpa
 */

public interface TeachplanRepository extends JpaRepository<Teachplan,String> {

    //根据课程id和parentid查询课程计划
    public List<Teachplan> findByCourseidAndParentid(String courseId,String parentId);
}
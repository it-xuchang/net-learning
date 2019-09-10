package com.netlearning.course.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.netlearning.framework.domain.course.CourseBase;


/**
 * @author No
 *持久层使用springdata jpa
 */
public interface CourseBaseRepository extends JpaRepository<CourseBase,String> {
}
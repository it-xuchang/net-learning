package com.netlearning.course.dao;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import com.netlearning.framework.domain.course.CourseBase;
import com.netlearning.framework.model.response.QueryResponseResult;


/**
 * @author No 持久层使用mybatis
 */
@Mapper
public interface CourseMapper {

	// 查询课程计划
	public CourseBase findCourseBaseById(String id);

	// 查询课程列表
	public Page<CourseBase> findCourseList();

	// 查询课程分类
	public QueryResponseResult findCategorylist();

	// 查询课程图片
	public QueryResponseResult findCoursePicList(String courseId);
}
package com.netlearning.api.course;

import com.netlearning.framework.domain.course.Category;
import com.netlearning.framework.domain.course.CourseBase;
import com.netlearning.framework.domain.course.Teachplan;
import com.netlearning.framework.domain.course.ext.TeachplanNode;
import com.netlearning.framework.domain.course.request.CourseListRequest;
import com.netlearning.framework.model.response.QueryResponseResult;
import com.netlearning.framework.model.response.ResponseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "课程接口", description = "课程管理接口，对课程的crud")
public interface CourseControllerApi {

	// 查询课程计划
	@ApiOperation("课程计划查询")
	public TeachplanNode findTeachplanList(String courseId);

	// 添加课程基础信息
	@ApiOperation("添加课程计划")
	public ResponseResult addTeachplan(Teachplan teachplan);

	// 查询课程列表
	@ApiOperation("查询教师课程列表，我的课程列表")
	public QueryResponseResult findCourseList(int page, int size, CourseListRequest courseListRequest);

	// 查询课程分类
	@ApiOperation("查询课程分类")
	public Category findCategorylist();
	
	
	
	

	// 添加课程基础信息
	@ApiOperation("添加课程基础信息")
	public ResponseResult addCourseBase(CourseBase courseBase);

	// 修改课程基础信息
	@ApiOperation("修改课程基础信息")
	public ResponseResult updateCourseBase(CourseBase courseBase);

	// 保存课程图片地址到课程数据库
	@ApiOperation("保存课程图片地址到课程数据库")
	public ResponseResult addCoursePic(String courseId, String pic);

	// 查询课程图片
	@ApiOperation("查询课程图片")
	public QueryResponseResult findCoursePicList(String courseId);

	// 删除课程图片
	@ApiOperation("删除课程图片")
	public ResponseResult deleteCoursePic(String courseId);

	

	//预览课程

	//发布课程

	//查询课程信息

	//保存媒资信息

}
package com.netlearning.course.service;

import com.netlearning.framework.domain.course.Category;
import com.netlearning.framework.domain.course.CourseBase;
import com.netlearning.framework.domain.course.Teachplan;
import com.netlearning.framework.domain.course.ext.TeachplanNode;
import com.netlearning.framework.domain.course.request.CourseListRequest;
import com.netlearning.framework.model.response.QueryResponseResult;
import com.netlearning.framework.model.response.ResponseResult;

public interface CourseService {

	TeachplanNode findTeachplanList(String courseId);

	ResponseResult addTeachplan(Teachplan teachplan);

	QueryResponseResult<M> findCourseList(int page, int size, CourseListRequest courseListRequest);

	Category findCategorylist();

	ResponseResult addCourseBase(CourseBase courseBase);

	ResponseResult updateCourseBase(CourseBase courseBase);

	ResponseResult addCoursePic(String courseId, String pic);

	QueryResponseResult<M> findCoursePicList(String courseId);

	ResponseResult deleteCoursePic(String courseId);

}

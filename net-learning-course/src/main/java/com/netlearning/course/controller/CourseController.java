package com.netlearning.course.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netlearning.api.course.CourseControllerApi;
import com.netlearning.course.service.CourseService;
import com.netlearning.framework.domain.course.Category;
import com.netlearning.framework.domain.course.CourseBase;
import com.netlearning.framework.domain.course.Teachplan;
import com.netlearning.framework.domain.course.ext.TeachplanNode;
import com.netlearning.framework.domain.course.request.CourseListRequest;
import com.netlearning.framework.model.response.QueryResponseResult;
import com.netlearning.framework.model.response.ResponseResult;

@RestController
@RequestMapping("/course")
public class CourseController implements CourseControllerApi {

    @Autowired
    private CourseService courseService;

    @Override
    @GetMapping("/teachplan/list/{courseId}")
    public TeachplanNode findTeachplanList(@PathVariable("courseId") String courseId) {
        return courseService.findTeachplanList(courseId);
    }

    @Override
    @PostMapping("/teachplan/add")
    public ResponseResult addTeachplan(@RequestBody  Teachplan teachplan) {

        return courseService.addTeachplan(teachplan);
    }

	@Override
	@GetMapping("/coursebase/list/{page}/{size}")
	public QueryResponseResult<M> findCourseList(@PathVariable("page") int page, @PathVariable("size") int size, CourseListRequest courseListRequest) {

		return courseService.findCourseList(page,size,courseListRequest);
	}

	@Override
	@GetMapping("/category/list")
	public Category findCategorylist() {

		return courseService.findCategorylist();
	}

	@Override
	@PostMapping("/coursebase/add")
	public ResponseResult addCourseBase(CourseBase courseBase) {

		return courseService.addCourseBase(courseBase);
	}

	@Override
	@PutMapping("/coursebase/update")
	public ResponseResult updateCourseBase(CourseBase courseBase) {
		return courseService.updateCourseBase(courseBase);
	}

	@Override
	@GetMapping("/coursepic/add")
	public ResponseResult addCoursePic(String courseId,String pic) {
		return courseService.addCoursePic(courseId,pic);
	}

	@Override
	@GetMapping("/coursepic/list/{courseId}")
	public QueryResponseResult<M> findCoursePicList(@PathVariable("courseId") String courseId) {

		return courseService.findCoursePicList(courseId);
	}

	@Override
	@DeleteMapping("/coursepic/delete")
	public ResponseResult deleteCoursePic(String courseId) {
		return courseService.deleteCoursePic(courseId);
	}
}

package com.netlearning.course.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;
import com.netlearning.course.dao.CourseBaseRepository;
import com.netlearning.course.dao.TeachplanMapper;
import com.netlearning.course.dao.TeachplanRepository;
import com.netlearning.course.service.CourseService;
import com.netlearning.framework.domain.course.Category;
import com.netlearning.framework.domain.course.CourseBase;
import com.netlearning.framework.domain.course.Teachplan;
import com.netlearning.framework.domain.course.ext.TeachplanNode;
import com.netlearning.framework.domain.course.request.CourseListRequest;
import com.netlearning.framework.exception.ExceptionCast;
import com.netlearning.framework.model.response.CommonCode;
import com.netlearning.framework.model.response.QueryResponseResult;
import com.netlearning.framework.model.response.ResponseResult;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	TeachplanRepository teachplanRepository;

	@Autowired
	CourseBaseRepository courseBaseRepository;

	@Autowired
	TeachplanMapper teachplanMapper;

	// 添加课程计划
	@Override
	@Transactional
	public ResponseResult addTeachplan(Teachplan teachplan) {
		if (teachplan == null || StringUtils.isEmpty(teachplan.getCourseid())
				|| StringUtils.isEmpty(teachplan.getPname())) {
			ExceptionCast.cast(CommonCode.INVALID_PARAM);
		}
		// 课程id
		String courseid = teachplan.getCourseid();
		// 页面传入的parentId
		String parentid = teachplan.getParentid();
		if (StringUtils.isEmpty(parentid)) {
			// 取出该课程的根结点
			parentid = this.getTeachplanRoot(courseid);
		}
		Optional<Teachplan> optional = teachplanRepository.findById(parentid);
		Teachplan parentNode = optional.get();
		// 父结点的级别
		String grade = parentNode.getGrade();
		// 新结点
		Teachplan teachplanNew = new Teachplan();
		// 将页面提交的teachplan信息拷贝到teachplanNew对象中
		BeanUtils.copyProperties(teachplan, teachplanNew);
		teachplanNew.setParentid(parentid);
		teachplanNew.setCourseid(courseid);
		if (grade.equals("1")) {
			teachplanNew.setGrade("2");// 级别，根据父结点的级别来设置
		} else {
			teachplanNew.setGrade("3");
		}

		teachplanRepository.save(teachplanNew);

		return new ResponseResult(CommonCode.SUCCESS);
	}

	// 查询课程的根结点，如果查询不到要自动添加根结点
	private String getTeachplanRoot(String courseId) {
		Optional<CourseBase> optional = courseBaseRepository.findById(courseId);
		if (!optional.isPresent()) {
			return null;
		}
		// 课程信息
		CourseBase courseBase = optional.get();
		// 查询课程的根结点
		List<Teachplan> teachplanList = teachplanRepository.findByCourseidAndParentid(courseId, "0");
		if (teachplanList == null || teachplanList.size() <= 0) {
			// 查询不到，要自动添加根结点
			Teachplan teachplan = new Teachplan();
			teachplan.setParentid("0");
			teachplan.setGrade("1");
			teachplan.setPname(courseBase.getName());
			teachplan.setCourseid(courseId);
			teachplan.setStatus("0");
			teachplanRepository.save(teachplan);
			return teachplan.getId();
		}
		// 返回根结点id
		return teachplanList.get(0).getId();

	}

	// 课程计划查询
	@Override
	public TeachplanNode findTeachplanList(String courseId) {
		return teachplanMapper.selectList(courseId);
	}

	@Override
	public QueryResponseResult findCourseList(int page, int size, CourseListRequest courseListRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findCategorylist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseResult addCourseBase(CourseBase courseBase) {
		// 为空返回异常
		if (courseBase == null || StringUtils.isEmpty(courseBase.getId())
				|| StringUtils.isEmpty(courseBase.getName())) {
			ExceptionCast.cast(CommonCode.INVALID_PARAM);
		}

		return new ResponseResult(CommonCode.SUCCESS);
	}

	@Override
	public ResponseResult updateCourseBase(CourseBase courseBase) {
		// 为空返回异常
		if (courseBase == null || StringUtils.isEmpty(courseBase.getId())
				|| StringUtils.isEmpty(courseBase.getName())) {
			ExceptionCast.cast(CommonCode.INVALID_PARAM);
		}

		return new ResponseResult(CommonCode.SUCCESS);
	}

	@Override
	public ResponseResult addCoursePic(String courseId, String pic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResponseResult findCoursePicList(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseResult deleteCoursePic(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}
}

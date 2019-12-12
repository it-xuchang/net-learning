package com.netlearning.search.service;

import com.netlearning.framework.domain.course.CoursePub;
import com.netlearning.framework.domain.course.TeachplanMediaPub;
import com.netlearning.framework.domain.search.CourseSearchParam;
import com.netlearning.framework.model.response.QueryResponseResult;

import java.util.Map;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/12 11:42
 */
public interface EsCourseService {
    QueryResponseResult<TeachplanMediaPub> getmedia(String[] teachplanIds);

    Map<String, CoursePub> getall(String id);

    QueryResponseResult<CoursePub> list(int page, int size, CourseSearchParam courseSearchParam);
}

package com.netlearning.user.client;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.client.NetLearningServiceList;
import com.netlearning.framework.domain.course.param.CourseRecommendationParam;
import com.netlearning.framework.domain.course.result.CourseBaseResult;
import com.netlearning.framework.domain.course.result.CourseRecommendationResult;
import com.netlearning.framework.domain.userAuth.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/6 18:46
 */
@Component
@FeignClient(value=NetLearningServiceList.COURSE_CENTER)
public interface CourseBaseClientApi {
    /**
     * 查询学生学习最多的课程信息
     * @param size
     * @return
     */
    @GetMapping(value = "/base/course/query/course/recommendation",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult<List<CourseRecommendationResult>> queryCourseRecommendation(@RequestParam(value = "size",required = false) Long size);

    /**
     * 根据课程查询教师
     * @param couresIds
     * @return
     */
    @GetMapping(value = "/base/course/query/course",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult<List<CourseBaseResult>> queryByCouresIds(@RequestParam(value = "couresIds",required = false) List<Long> couresIds);
}

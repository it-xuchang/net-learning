package com.netlearning.framework.domain.course.result;

import lombok.Data;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/6 15:05
 */
@Data
public class RecommendedCourseDirectionResult {
    private String courseDirectionName;
    private String leftImageUrl;
    private String headerImageUrl;
    private List<CourseCategoryDirectionResult> courseCategory;
    private List<CourseDirectionResult> courseItem;
}

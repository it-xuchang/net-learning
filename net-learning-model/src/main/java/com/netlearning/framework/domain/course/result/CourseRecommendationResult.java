package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/6 12:48
 */
@Data
public class CourseRecommendationResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    private String courseName;
    private String courseImageUrl;
    private String courseGrdle;
    private int learningUser;
}

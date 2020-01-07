package com.netlearning.framework.domain.userAuth.result;

import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/6 12:48
 */
@Data
public class TeacherRecommendationResult {
    private Long teacherId;
    private String teacherName;
    private String courseName;
    private String avatar;
    private String teacherImageUrl;
    private int learningUser;
}

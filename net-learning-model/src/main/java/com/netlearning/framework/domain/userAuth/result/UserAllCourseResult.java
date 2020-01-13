package com.netlearning.framework.domain.userAuth.result;

import lombok.Data;

import java.util.Date;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/8 9:59
 */
@Data
public class UserAllCourseResult {
    private Long courseId;
    private String courseName;

    private Date startTime;

}

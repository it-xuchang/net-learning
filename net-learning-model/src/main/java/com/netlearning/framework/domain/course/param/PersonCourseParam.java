package com.netlearning.framework.domain.course.param;

import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/2/11 21:41
 */
@Data
public class PersonCourseParam {
    private Long userId;
    private String orderBy;
    private Integer pageNum;
    private Integer pageSize;
}

package com.netlearning.framework.domain.course.param;

import lombok.Data;


@Data
public class CourseFavoriteAddParam {

    private Long userId;
    private Long courseId;

}

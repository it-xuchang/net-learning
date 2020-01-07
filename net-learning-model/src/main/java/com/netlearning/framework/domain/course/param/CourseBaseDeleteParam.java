package com.netlearning.framework.domain.course.param;

import lombok.Data;

import java.util.List;

@Data
public class CourseBaseDeleteParam {
    private Long courseId;

    private Long teacherId;

    private List<Long> courseIds;
}

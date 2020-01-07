package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserLearningCourseResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    private List<LearningCourseResult> learningCourseResults;

}

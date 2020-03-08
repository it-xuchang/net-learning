package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

@Data
public class TeachPlanResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long teachplanId;

    private String teachplanName;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    private String grade;

    private String teachplanType;

    private String description;

    private Double timeLength;

    private String courseId;

    private String orderby;

    private String status;

    private String tryLearn;

    private List<TeachPlanMediaResult> teachPlanMediaResults;

    private List<TeachPlanResult> subTeachPlanResult;

    private String mediaUrl;

}

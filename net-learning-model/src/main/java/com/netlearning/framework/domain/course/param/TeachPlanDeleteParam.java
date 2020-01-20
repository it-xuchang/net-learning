package com.netlearning.framework.domain.course.param;

import lombok.Data;

import java.util.List;

@Data
public class TeachPlanDeleteParam {
    private List<Long> teachplanIds;


}

package com.netlearning.framework.domain.userAuth.param;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDeleteParam {
    private Long teacherId;
    private List<Long> teacherIds;
}

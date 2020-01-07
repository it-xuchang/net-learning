package com.netlearning.framework.domain.course.param;

import lombok.Data;

@Data
public class FrequentlyAskedQuestionEditParam {

    private Long frequentlyAskedQuestionId;

    private String frequentlyAskedQuestionTitle;

    private String frequentlyAskedQuestionContent;

    private Long courseId;

}

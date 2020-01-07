package com.netlearning.framework.domain.course.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class FrequentlyAskedQuestionAddParam {

    private String frequentlyAskedQuestionTitle;

    private String frequentlyAskedQuestionContent;

    private Long courseId;

}

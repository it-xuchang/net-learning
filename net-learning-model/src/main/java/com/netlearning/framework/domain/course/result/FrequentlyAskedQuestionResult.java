package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class FrequentlyAskedQuestionResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long frequentlyAskedQuestionId;

    private String frequentlyAskedQuestionTitle;

    private String frequentlyAskedQuestionContent;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long courseId;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateTime;

}

package com.netlearning.framework.domain.course;

import java.util.Date;

public class FrequentlyAskedQuestion {
    private Long frequentlyAskedQuestionId;

    private String frequentlyAskedQuestionTitle;

    private String frequentlyAskedQuestionContent;

    private Long courseId;

    private Date createTime;

    private Date updateTime;

    public Long getFrequentlyAskedQuestionId() {
        return frequentlyAskedQuestionId;
    }

    public void setFrequentlyAskedQuestionId(Long frequentlyAskedQuestionId) {
        this.frequentlyAskedQuestionId = frequentlyAskedQuestionId;
    }

    public String getFrequentlyAskedQuestionTitle() {
        return frequentlyAskedQuestionTitle;
    }

    public void setFrequentlyAskedQuestionTitle(String frequentlyAskedQuestionTitle) {
        this.frequentlyAskedQuestionTitle = frequentlyAskedQuestionTitle;
    }

    public String getFrequentlyAskedQuestionContent() {
        return frequentlyAskedQuestionContent;
    }

    public void setFrequentlyAskedQuestionContent(String frequentlyAskedQuestionContent) {
        this.frequentlyAskedQuestionContent = frequentlyAskedQuestionContent;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

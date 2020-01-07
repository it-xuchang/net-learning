package com.netlearning.framework.domain.course;

import java.util.Date;

public class LearningCourse {
    private Long learningId;

    private Long courseId;

    private Long userId;

    private String valid;

    private Date createTime;

    private Date endTime;

    private String status;

    public Long getLearningId() {
        return learningId;
    }

    public void setLearningId(Long learningId) {
        this.learningId = learningId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.netlearning.framework.domain.course;

import java.util.Date;

public class LearningTeachplan {
    private Long learningTeachplanId;

    private Long teachplanId;

    private Long userId;

    private Double learningTime;

    private Date createTime;

    private Date endTime;

    private String status;

    private Long courseId;

    public Long getLearningTeachplanId() {
        return learningTeachplanId;
    }

    public void setLearningTeachplanId(Long learningTeachplanId) {
        this.learningTeachplanId = learningTeachplanId;
    }

    public Long getTeachplanId() {
        return teachplanId;
    }

    public void setTeachplanId(Long teachplanId) {
        this.teachplanId = teachplanId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getLearningTime() {
        return learningTime;
    }

    public void setLearningTime(Double learningTime) {
        this.learningTime = learningTime;
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}

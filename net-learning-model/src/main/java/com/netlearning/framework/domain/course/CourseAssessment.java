package com.netlearning.framework.domain.course;

import java.util.Date;

public class CourseAssessment {
    private Long courseAssessmentId;

    private String courseAssessmentTitle;

    private String courseAssessmentContent;

    private Double courseAssessmentGrade;

    private Date createTime;

    private Long courseId;

    private Long userId;

    private Date updateTime;

    public Long getCourseAssessmentId() {
        return courseAssessmentId;
    }

    public void setCourseAssessmentId(Long courseAssessmentId) {
        this.courseAssessmentId = courseAssessmentId;
    }

    public String getCourseAssessmentTitle() {
        return courseAssessmentTitle;
    }

    public void setCourseAssessmentTitle(String courseAssessmentTitle) {
        this.courseAssessmentTitle = courseAssessmentTitle;
    }

    public String getCourseAssessmentContent() {
        return courseAssessmentContent;
    }

    public void setCourseAssessmentContent(String courseAssessmentContent) {
        this.courseAssessmentContent = courseAssessmentContent;
    }

    public Double getCourseAssessmentGrade() {
        return courseAssessmentGrade;
    }

    public void setCourseAssessmentGrade(Double courseAssessmentGrade) {
        this.courseAssessmentGrade = courseAssessmentGrade;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

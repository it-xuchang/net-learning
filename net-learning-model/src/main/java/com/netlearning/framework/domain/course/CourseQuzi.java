package com.netlearning.framework.domain.course;

import java.util.Date;

public class CourseQuzi {
    private Long courseQuziId;

    private String courseQuziTitle;

    private String courseQuziContent;

    private Date createTime;

    private String isOverHead;

    private Long courseId;

    private Date updateTime;

    private String courseQuziType;

    private String isShow;

    public Long getCourseQuziId() {
        return courseQuziId;
    }

    public void setCourseQuziId(Long courseQuziId) {
        this.courseQuziId = courseQuziId;
    }

    public String getCourseQuziTitle() {
        return courseQuziTitle;
    }

    public void setCourseQuziTitle(String courseQuziTitle) {
        this.courseQuziTitle = courseQuziTitle;
    }

    public String getCourseQuziContent() {
        return courseQuziContent;
    }

    public void setCourseQuziContent(String courseQuziContent) {
        this.courseQuziContent = courseQuziContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsOverHead() {
        return isOverHead;
    }

    public void setIsOverHead(String isOverHead) {
        this.isOverHead = isOverHead;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCourseQuziType() {
        return courseQuziType;
    }

    public void setCourseQuziType(String courseQuziType) {
        this.courseQuziType = courseQuziType;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }
}

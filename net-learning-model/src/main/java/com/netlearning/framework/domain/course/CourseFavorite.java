package com.netlearning.framework.domain.course;

import java.util.Date;

public class CourseFavorite {
    private Long courseFavoriteId;

    private Long userId;

    private Date createTime;

    private Date endTime;

    private Long courseId;

    public Long getCourseFavoriteId() {
        return courseFavoriteId;
    }

    public void setCourseFavoriteId(Long courseFavoriteId) {
        this.courseFavoriteId = courseFavoriteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}

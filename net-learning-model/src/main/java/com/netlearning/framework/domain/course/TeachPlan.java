package com.netlearning.framework.domain.course;

public class TeachPlan {
    private Long teachplanId;

    private String teachplanName;

    private Long parentId;

    private String grade;

    private String teachplanType;

    private String description;

    private Double timeLength;

    private String courseId;

    private String orderby;

    private String status;

    private String tryLearn;

    public Long getTeachplanId() {
        return teachplanId;
    }

    public void setTeachplanId(Long teachplanId) {
        this.teachplanId = teachplanId;
    }

    public String getTeachplanName() {
        return teachplanName;
    }

    public void setTeachplanName(String teachplanName) {
        this.teachplanName = teachplanName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTeachplanType() {
        return teachplanType;
    }

    public void setTeachplanType(String teachplanType) {
        this.teachplanType = teachplanType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Double timeLength) {
        this.timeLength = timeLength;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTryLearn() {
        return tryLearn;
    }

    public void setTryLearn(String tryLearn) {
        this.tryLearn = tryLearn;
    }
}

package com.netlearning.framework.domain.course;

public class SystemNav {
    private Long systemNavId;

    private String systemNavUrl;

    private Long courseId;

    private Long fromSystemId;

    private String systemNavHandlers;

    public Long getSystemNavId() {
        return systemNavId;
    }

    public void setSystemNavId(Long systemNavId) {
        this.systemNavId = systemNavId;
    }

    public String getSystemNavUrl() {
        return systemNavUrl;
    }

    public void setSystemNavUrl(String systemNavUrl) {
        this.systemNavUrl = systemNavUrl;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getFromSystemId() {
        return fromSystemId;
    }

    public void setFromSystemId(Long fromSystemId) {
        this.fromSystemId = fromSystemId;
    }

    public String getSystemNavHandlers() {
        return systemNavHandlers;
    }

    public void setSystemNavHandlers(String systemNavHandlers) {
        this.systemNavHandlers = systemNavHandlers;
    }
}

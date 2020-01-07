package com.netlearning.framework.domain.course;

public class TeachPlanMedia {
    private Long teachplanMediaId;

    private Long mediaId;

    private String mediaFileoriginalName;

    private String mediaUrl;

    private Long courseId;

    private Long teachplanId;

    private Long recordId;

    public Long getTeachplanMediaId() {
        return teachplanMediaId;
    }

    public void setTeachplanMediaId(Long teachplanMediaId) {
        this.teachplanMediaId = teachplanMediaId;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaFileoriginalName() {
        return mediaFileoriginalName;
    }

    public void setMediaFileoriginalName(String mediaFileoriginalName) {
        this.mediaFileoriginalName = mediaFileoriginalName;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTeachplanId() {
        return teachplanId;
    }

    public void setTeachplanId(Long teachplanId) {
        this.teachplanId = teachplanId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }
}

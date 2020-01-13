package com.netlearning.framework.domain.course;

public class TeachPlanMediaTencent {
    private Long teachplanMediaTencentId;

    private Long teachplanMediaId;

    private String tencentMediaUrl;

    private Long tencentFileid;

    private String tencentCoverUrl;

    public Long getTeachplanMediaTencentId() {
        return teachplanMediaTencentId;
    }

    public void setTeachplanMediaTencentId(Long teachplanMediaTencentId) {
        this.teachplanMediaTencentId = teachplanMediaTencentId;
    }

    public Long getTeachplanMediaId() {
        return teachplanMediaId;
    }

    public void setTeachplanMediaId(Long teachplanMediaId) {
        this.teachplanMediaId = teachplanMediaId;
    }

    public String getTencentMediaUrl() {
        return tencentMediaUrl;
    }

    public void setTencentMediaUrl(String tencentMediaUrl) {
        this.tencentMediaUrl = tencentMediaUrl;
    }

    public Long getTencentFileid() {
        return tencentFileid;
    }

    public void setTencentFileid(Long tencentFileid) {
        this.tencentFileid = tencentFileid;
    }

    public String getTencentCoverUrl() {
        return tencentCoverUrl;
    }

    public void setTencentCoverUrl(String tencentCoverUrl) {
        this.tencentCoverUrl = tencentCoverUrl;
    }
}

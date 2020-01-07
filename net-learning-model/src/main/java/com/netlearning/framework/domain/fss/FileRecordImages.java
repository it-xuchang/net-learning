package com.netlearning.framework.domain.fss;

public class FileRecordImages {
    private Long recordImageId;

    private Long recordId;

    private Long fromSystemId;

    private Long userId;

    private String isDefault;

    private String isDefaultIcon;

    public Long getRecordImageId() {
        return recordImageId;
    }

    public void setRecordImageId(Long recordImageId) {
        this.recordImageId = recordImageId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getFromSystemId() {
        return fromSystemId;
    }

    public void setFromSystemId(Long fromSystemId) {
        this.fromSystemId = fromSystemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getIsDefaultIcon() {
        return isDefaultIcon;
    }

    public void setIsDefaultIcon(String isDefaultIcon) {
        this.isDefaultIcon = isDefaultIcon;
    }
}

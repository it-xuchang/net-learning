package com.netlearning.framework.domain.userAuth;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class UserConfig {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String theme;

    private String layout;

    private String multiPage;

    private String fixSiderbar;

    private String fixHeader;

    private String color;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getMultiPage() {
        return multiPage;
    }

    public void setMultiPage(String multiPage) {
        this.multiPage = multiPage;
    }

    public String getFixSiderbar() {
        return fixSiderbar;
    }

    public void setFixSiderbar(String fixSiderbar) {
        this.fixSiderbar = fixSiderbar;
    }

    public String getFixHeader() {
        return fixHeader;
    }

    public void setFixHeader(String fixHeader) {
        this.fixHeader = fixHeader;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

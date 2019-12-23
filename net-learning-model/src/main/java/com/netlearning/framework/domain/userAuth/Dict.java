package com.netlearning.framework.domain.userAuth;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Dict {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long dictId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long keyy;

    private String valuee;

    private String fieldName;

    private String tableName;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public Long getKeyy() {
        return keyy;
    }

    public void setKeyy(Long keyy) {
        this.keyy = keyy;
    }

    public String getValuee() {
        return valuee;
    }

    public void setValuee(String valuee) {
        this.valuee = valuee;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}

package com.netlearning.framework.domain.userAuth;

import lombok.Data;

@Data
public class DictParam {
    private Long dictId;

    private Long key;

    private String value;

    private String fieldName;

    private String tableName;

}

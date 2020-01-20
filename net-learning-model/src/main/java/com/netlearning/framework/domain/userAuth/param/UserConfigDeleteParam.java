package com.netlearning.framework.domain.userAuth.param;

import lombok.Data;

import java.util.List;

@Data
public class UserConfigDeleteParam {
    private List<Long> userIds;
}

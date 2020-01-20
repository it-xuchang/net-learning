package com.netlearning.framework.domain.userAuth.param;

import lombok.Data;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:44
 */
@Data
public class UserDeleteParam {
    private List<Long> userIds;
}

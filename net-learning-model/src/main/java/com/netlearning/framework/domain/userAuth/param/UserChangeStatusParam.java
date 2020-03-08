package com.netlearning.framework.domain.userAuth.param;

import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:44
 */
@Data
public class UserChangeStatusParam {
    private Long userId;
    private String status;


}

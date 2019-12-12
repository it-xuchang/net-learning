package com.netlearning.framework.domain.fss.response;

import lombok.Data;
import lombok.ToString;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/4 16:39
 */
@Data
@ToString
public class AccessTokenResult {
    private String  fileAccessToken;
    private String  uniqueId;
    private String  type;
}

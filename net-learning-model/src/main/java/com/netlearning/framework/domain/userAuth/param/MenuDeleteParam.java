package com.netlearning.framework.domain.userAuth.param;


import lombok.Data;

import java.util.List;


@Data
public class MenuDeleteParam {
    private List<Long> menuIds;
}

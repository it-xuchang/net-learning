package com.netlearning.framework.domain.userAuth.param;


import lombok.Data;


@Data
public class MenuDeleteParam {
    private Long menuId;
    private Long parentId;
}

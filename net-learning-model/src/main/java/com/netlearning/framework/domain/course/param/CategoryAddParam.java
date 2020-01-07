package com.netlearning.framework.domain.course.param;

import lombok.Data;

@Data
public class CategoryAddParam {

    private String categoryName;

    private String label;

    private Long parentId;

    private String isShow;

    private String isLeaf;

}

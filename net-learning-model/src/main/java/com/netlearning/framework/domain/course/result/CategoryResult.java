package com.netlearning.framework.domain.course.result;

import lombok.Data;

@Data
public class CategoryResult {
    private Long categoryId;

    private String categoryName;

    private String label;

    private Long parentId;

    private String isShow;

    private String isLeaf;

}

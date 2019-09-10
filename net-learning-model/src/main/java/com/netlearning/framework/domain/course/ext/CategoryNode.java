package com.netlearning.framework.domain.course.ext;

import com.netlearning.framework.domain.course.Category;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CategoryNode extends Category {

    List<CategoryNode> children;

}

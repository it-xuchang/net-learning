package com.netlearning.framework.domain.ucenter.ext;

import com.netlearning.framework.domain.course.ext.CategoryNode;
import com.netlearning.framework.domain.ucenter.NetLearningMenu;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class NetLearningMenuExt extends NetLearningMenu {

    List<CategoryNode> children;
}

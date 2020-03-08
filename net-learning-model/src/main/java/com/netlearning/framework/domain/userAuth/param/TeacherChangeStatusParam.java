package com.netlearning.framework.domain.userAuth.param;

import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/20 14:44
 */
@Data
public class TeacherChangeStatusParam {
    private Long teacherId;
    private String status;


}

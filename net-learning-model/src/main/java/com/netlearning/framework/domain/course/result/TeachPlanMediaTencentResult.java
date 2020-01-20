package com.netlearning.framework.domain.course.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/10 11:51
 */
@Data
public class TeachPlanMediaTencentResult {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long teachplanMediaTencentId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long teachplanMediaId;

    private String tencentMediaUrl;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long tencentFileid;

    private String tencentCoverUrl;
}

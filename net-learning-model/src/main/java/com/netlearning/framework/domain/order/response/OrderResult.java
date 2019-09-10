package com.netlearning.framework.domain.order.response;

import com.netlearning.framework.domain.order.NetLearningOrders;
import com.netlearning.framework.model.response.ResponseResult;
import com.netlearning.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/26.
 */
@Data
@ToString
public class OrderResult extends ResponseResult {
    private NetLearningOrders xcOrders;
    public OrderResult(ResultCode resultCode, NetLearningOrders xcOrders) {
        super(resultCode);
        this.xcOrders = xcOrders;
    }


}

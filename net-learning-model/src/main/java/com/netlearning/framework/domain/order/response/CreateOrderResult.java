package com.netlearning.framework.domain.order.response;

import com.netlearning.framework.domain.order.NetLearningOrders;
import com.netlearning.framework.model.response.ResponseResult;
import com.netlearning.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateOrderResult extends ResponseResult {
    private NetLearningOrders xcOrders;
    public CreateOrderResult(ResultCode resultCode, NetLearningOrders xcOrders) {
        super(resultCode);
        this.xcOrders = xcOrders;
    }


}

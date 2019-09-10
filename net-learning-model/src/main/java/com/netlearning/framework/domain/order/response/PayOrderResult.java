package com.netlearning.framework.domain.order.response;

import com.netlearning.framework.domain.order.NetLearningOrdersPay;
import com.netlearning.framework.model.response.ResponseResult;
import com.netlearning.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PayOrderResult extends ResponseResult {
    public PayOrderResult(ResultCode resultCode) {
        super(resultCode);
    }
    public PayOrderResult(ResultCode resultCode,NetLearningOrdersPay xcOrdersPay) {
        super(resultCode);
        this.xcOrdersPay = xcOrdersPay;
    }
    private NetLearningOrdersPay xcOrdersPay;
    private String orderNumber;

    //当tradeState为NOTPAY（未支付）时显示支付二维码
    private String codeUrl;
    private Float money;


}

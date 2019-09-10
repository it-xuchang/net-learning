package com.netlearning.framework.domain.order.response;

import com.netlearning.framework.model.response.ResponseResult;
import com.netlearning.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PayQrcodeResult extends ResponseResult {
    public PayQrcodeResult(ResultCode resultCode){
        super(resultCode);
    }
    private String codeUrl;
    private Float money;
    private String orderNumber;

}

package com.netlearning.framework.domain.ucenter.response;

import com.netlearning.framework.model.response.ResponseResult;
import com.netlearning.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class JwtResult extends ResponseResult {
    public JwtResult(ResultCode resultCode, String jwt) {
        super(resultCode);
        this.jwt = jwt;
    }
    private String jwt;
}

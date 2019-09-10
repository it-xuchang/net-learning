package com.netlearning.framework.exception;

import com.netlearning.framework.model.response.ResultCode;


public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}

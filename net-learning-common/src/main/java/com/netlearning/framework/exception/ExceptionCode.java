package com.netlearning.framework.exception;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/10 10:36
 */
public class ExceptionCode {
    public enum FssCode{
        CODE001("CODE001" , "系统内部错误"),
        CODE002("CODE002" , "文件未获取上传权限"),

        ;
        public final String code;
        public final String message;

        FssCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}

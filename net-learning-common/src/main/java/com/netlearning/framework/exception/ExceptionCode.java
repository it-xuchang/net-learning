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
        CODE003("CODE003" , "用户id不允许为空"),
        CODE004("CODE004" , "上传token不允许为空"),
        CODE005("CODE005" , "上传文件不允许为空"),
        CODE006("CODE006" , "操作类型有误"),

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

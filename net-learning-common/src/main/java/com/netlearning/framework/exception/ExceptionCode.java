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
        CODE007("CODE007" , "文件上传失败"),

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
    public enum UserAuthCode{
        CODE001("CODE001" , "系统内部错误"),
        CODE002("CODE002" , "添加失败"),
        CODE003("CODE003" , "修改失败"),
        CODE004("CODE004" , "删除失败"),
        CODE005("CODE005" , "分页参数错误"),
        CODE006("CODE006" , "日期格式错误"),
        CODE007("CODE007" , "参数输入有误"),
        CODE008("CODE008" , "数据不存在"),
        CODE009("CODE009" , "用户密码不允许为空"),
        CODE010("CODE010" , "手机或者邮箱不允许为空"),
        CODE011("CODE011" , "用户状态有误"),
        CODE012("CODE012" , "性别状态有误"),
        CODE013("CODE013" , "用户角色已存在"),
        CODE014("CODE014" , "用户不存在"),
        CODE015("CODE015" , "角色不存在"),
        CODE016("CODE016" , "用户角色不存在"),
        ;
        public final String code;
        public final String message;

        UserAuthCode(String code, String message) {
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
    public enum AuthCode{
        CODE001("CODE001" , "系统内部错误"),
        CODE002("CODE002" , "添加失败"),
        CODE003("CODE003" , "账号或密码错误"),
        CODE004("CODE004" , "用户账号锁定"),
        ;
        public final String code;
        public final String message;

        AuthCode(String code, String message) {
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
    public enum CourseCode{
        CODE001("CODE001" , "系统内部错误"),
        CODE002("CODE002" , "添加失败"),
        CODE003("CODE003" , "修改失败"),
        CODE004("CODE004" , "删除失败"),
        CODE005("CODE005" , "分页参数错误"),
        CODE006("CODE006" , "日期格式错误"),
        CODE007("CODE007" , "参数输入有误"),
        CODE008("CODE008" , "课程不存在"),
        CODE009("CODE009" , "课程id输入有误"),
        CODE010("CODE010" , "课程暂无教学计划"),

        ;
        public final String code;
        public final String message;

        CourseCode(String code, String message) {
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

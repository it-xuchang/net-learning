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
        CODE017("CODE017" , "用户id为空"),
        CODE018("CODE018" , "名称已存在"),
        CODE019("CODE019" , "邮箱已存在"),
        CODE020("CODE020" , "手机号已存在"),
        CODE021("CODE021" , "密码不允许为空"),
        CODE022("CODE022" , "账号或密码错误"),
        CODE023("CODE023" , "账号被锁定"),
        CODE024("CODE024" , "新旧密码一致"),
        CODE025("CODE025" , "输入密码一致"),
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
        CODE005("CODE005" , "手机号码格式错误"),
        CODE006("CODE006" , "邮箱格式错误"),
        CODE007("CODE007" , "用户名或密码为空"),
        CODE008("CODE008" , "账号类型有误"),
        CODE009("CODE009" , "用户类型有误"),
        CODE010("CODE010" , "用户角色有误"),
        CODE011("CODE011" , "用户角色资源有误"),
        CODE012("CODE012" , "请输入正确的手机号或者邮箱"),
        CODE013("CODE013" , "请输入验证码"),
        CODE014("CODE014" , "请获取验证码"),
        CODE015("CODE015" , "验证码输入有误"),
        CODE016("CODE016" , "账号不存在，请注册"),
        CODE017("CODE016" , "修改密码错误"),
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
        CODE011("CODE011" , "已加入课程"),
        CODE012("CODE012" , "课程id为空"),
        CODE013("CODE013" , "用户id为空"),
        CODE014("CODE014" , "课程计划id为空"),
        CODE015("CODE015" , "课程已收藏"),
        CODE016("CODE016" , "课程分类id为空"),
        CODE017("CODE017" , "课程分类名称为空"),
        CODE018("CODE018" , "课程分类描述为空"),
        CODE019("CODE019" , "课程名为空"),
        CODE020("CODE020" , "课程分类为空"),
        CODE021("CODE021" , "课程描述为空"),
        CODE022("CODE022" , "学习模式为空"),
        CODE023("CODE023" , "教学模式为空"),
        CODE024("CODE024" , "教师id为空"),
        CODE025("CODE025" , "课程状态有误"),

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

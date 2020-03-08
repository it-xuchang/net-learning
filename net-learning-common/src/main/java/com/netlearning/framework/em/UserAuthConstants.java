package com.netlearning.framework.em;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/10 10:00
 */
public interface UserAuthConstants {
    enum UserType {
        UP("1", "有效"),
        DOWN("0", "锁定");

        private String code;
        private String message;

        private UserType(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<String> userTypeList() {
            List<String> typeList = new ArrayList<>();
            for (UserType v : UserType.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }
    enum UserLoginType {
        EMAIL("1", "邮箱"),
        MOBILE("0", "手机号");

        private String code;
        private String message;

        private UserLoginType(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<String> userTypeList() {
            List<String> typeList = new ArrayList<>();
            for (UserLoginType v : UserLoginType.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }
    enum UserLoginAccountType {
        USER("1", "学生"),
        TEACHER("0", "教师");

        private String code;
        private String message;

        private UserLoginAccountType(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<String> userTypeList() {
            List<String> typeList = new ArrayList<>();
            for (UserLoginAccountType v : UserLoginAccountType.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }
    enum UserSexType {
        NON("2", "保密"),
        MAN("0", "女"),
        WOMAN("1", "男");

        private String code;
        private String message;

        private UserSexType(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<String> userSexTypeList() {
            List<String> typeList = new ArrayList<>();
            for (UserSexType v : UserSexType.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }
    enum SystemDefaultRole {
        SYSTEM_DEFAULT_ADMIN(101L, "超级管理员"),
        SYSTEM_DEFAULT_TEACHER(100L, "普通教师"),
        SYSTEM_DEFAULT_STUDENT(102L, "普通学生"),
        ;

        private Long code;
        private String message;

        private SystemDefaultRole(Long code, String message) {
            this.code = code;
            this.message = message;
        }

        public Long getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<Long> defaultRoleList() {
            List<Long> typeList = new ArrayList<>();
            for (SystemDefaultRole v : SystemDefaultRole.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }
}

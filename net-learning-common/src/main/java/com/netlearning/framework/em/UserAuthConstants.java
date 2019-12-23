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
            for (UserType v : UserType.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }
}

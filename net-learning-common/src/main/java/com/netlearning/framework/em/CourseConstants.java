package com.netlearning.framework.em;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/10 10:00
 */
public interface CourseConstants {

    enum CategoryType {
        SHOW("0", "显示"),
        NON_SHOW("1", "不显示"),
        LEAF("0", "父节点"),
        NON_LEAF("1", "子节点"),
        ;

        private String code;
        private String message;

        private CategoryType(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<String> categoryTypeList() {
            List<String> typeList = new ArrayList<>();
            for (CategoryType v : CategoryType.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }
    enum CourseType {
        RELEASE("0", "发布"),
        UPLOAD_IMAGES("1", "上传图片"),
        ADD_LEARNING_COURSE("2", "添加课程计划"),
        OFF_LINE("3", "下线"),
        ;

        private String code;
        private String message;

        private CourseType(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<String> courseTypeList() {
            List<String> typeList = new ArrayList<>();
            for (CourseType v : CourseType.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }

    enum IsOverHead {
        OVER_HEAD("0", "顶置"),
        NON_OVER_HEAD("1", "未顶置"),
        ;

        private String code;
        private String message;

        private IsOverHead(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<String> typeList() {
            List<String> typeList = new ArrayList<>();
            for (IsOverHead v : IsOverHead.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }

    enum IsShow {
        SHOW("0", "显示"),
        NON_SHOW("1", "不显示"),
        ;

        private String code;
        private String message;

        private IsShow(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<String> typeList() {
            List<String> typeList = new ArrayList<>();
            for (IsShow v : IsShow.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }
}

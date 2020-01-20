package com.netlearning.framework.em;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/10 10:00
 */
public interface FileConstants {
    enum FileRequestType {
        UPLOAD("0", "上传"),
        DOWNLOAD("1", "下载");

        private String code;
        private String message;

        private FileRequestType(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<String> FileTypeList() {
            List<String> typeList = new ArrayList<>();
            for (FileRequestType v : FileRequestType.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }
    enum IsAvatar {
        AVATAR("0", "用户头像"),
        NON_AVATAR("1", "非用户头像"),
        ;
        private String code;
        private String message;

        IsAvatar(String code, String message) {
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
    enum FileType {
        IMAGES("0", "图片"),
        DOCUMENT("1", "文档"),
        MEDIA("2", "视频"),
        OTHER("3", "其他"),
        AVATAR("4", "头像"),
        ;

        private String code;
        private String message;

        private FileType(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<String> FileTypeList() {
            List<String> typeList = new ArrayList<>();
            for (FileType v : FileType.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }

    enum IsUseType {
        USE("0", "使用"),
        NON_USE("1", "不使用");

        private String code;
        private String message;

        private IsUseType(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static List<String> isUseTypeList() {
            List<String> typeList = new ArrayList<>();
            for (IsUseType v : IsUseType.values()) {
                typeList.add(v.code);
            }
            return typeList;
        }
    }

}

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
}

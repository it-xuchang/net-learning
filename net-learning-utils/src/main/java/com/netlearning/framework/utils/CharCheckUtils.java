package com.netlearning.framework.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 */
public class CharCheckUtils {

    /**
     * 手机号码前三后四脱敏
     * @param mobile
     * @return
     */
    public static String mobileEncrypt(String mobile) {
        if (StringUtils.isEmpty(mobile) || (mobile.length() != 11)) {
            return mobile;
        }
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 身份证前三后四脱敏
     * @param id
     * @return
     */
    public static String idEncrypt(String id) {
        if (StringUtils.isEmpty(id) || (id.length() < 8)) {
            return id;
        }
        return id.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
    }

    /**
     * 护照前2后3位脱敏，护照一般为8或9位
     * @param id
     * @return
     */
    public static String idPassport(String id) {
        if (StringUtils.isEmpty(id) || (id.length() < 8)) {
            return id;
        }
        return id.substring(0, 2) + new String(new char[id.length() - 5]).replace("\0", "*") + id.substring(id.length() - 3);
    }

    /**
     * 判断list是否相同
     * @param list1
     * @param list2
     * @return
     */
    public static boolean isEquals(List<String> list1, List<String> list2){
        if(null != list1 && null != list2){
            if(list1.containsAll(list2) && list2.containsAll(list1)){
                return true;
            }
            return false;
        }
        return true;
    }
}

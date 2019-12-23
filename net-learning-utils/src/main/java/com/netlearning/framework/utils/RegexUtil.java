package com.netlearning.framework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 */
public class RegexUtil {
    private final static String POSITIVE_NUMBER_PATTERN = "^[1-9]\\d*$";

    private final static String POSIT_NUMBER_PATTERN = "^[0-9]\\d*$";

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";


    private static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String DATETIME_FORMAT = "yyyyMMddHHmmss";
    /**
     * 正整数 不包括0
     * @param testStr
     * @return
     */
    public static   boolean checkPositiveNum(Integer testStr){
        Pattern pattern= Pattern.compile(POSITIVE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(testStr.toString());
        return matcher.matches();
    }
    /**
     * 正整数包括0
     * @param testStr
     * @return
     */
    public static   boolean checkPositNum(Integer testStr){
        Pattern pattern= Pattern.compile(POSIT_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(testStr.toString());
        return matcher.matches();
    }
    /**
     * 校验日期
     * @param date
     * @return
     */
    public static boolean checkDatePattern(String date){
        if (StringUtils.isEmpty(date)){
            return false;
        }
        String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
        Pattern patternDate = Pattern.compile(rexp);
        Matcher matcherDate = patternDate.matcher(date);
        boolean dateType = matcherDate.matches();
        return dateType;
    }


    public static boolean checkPositNum(Long deptId) {
        Pattern pattern= Pattern.compile(POSIT_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(deptId.toString());
        return matcher.matches();
    }
}

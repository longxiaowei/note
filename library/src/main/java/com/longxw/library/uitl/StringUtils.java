package com.longxw.library.uitl;

/**
 * @author longxw
 * @since 2020/5/12
 */
public class StringUtils {

    public static boolean isNullOrEmpty(String s){
        return s == null || s.length() == 0;
    }

    public static boolean isNotEmpty(String s){
        return !isNullOrEmpty(s);
    }

    public static boolean isNotBlank(String s){
        return isNotEmpty(s) || s.trim().length()!=0;
    }

    /**
     * 首字母转大写
     * @param s
     * @return
     */
    public static String toUpperCaseFirstChar(String s){
        if (!isNotBlank(s)) {
            throw new IllegalArgumentException("非法的字符串输入： " + s);
        }

        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        }

        first = Character.toUpperCase(first);
        return new StringBuilder().append(first).append(s.substring(1)).toString();
    }

    /**
     * 首字母转小写
     * @param s
     * @return
     */
    public static String toLowerCaseFirstChar(String s){
        if (!isNotBlank(s)) {
            throw new IllegalArgumentException("非法的字符串输入： " + s);
        }

        char first = s.charAt(0);
        if (Character.isLowerCase(first)) {
            return s;
        }

        first = Character.toLowerCase(first);
        return new StringBuilder().append(first).append(s.substring(1)).toString();
    }
}

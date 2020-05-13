package com.longxw.library.uitl;

/**
 * @author longxw
 * @since 2020/5/12
 */
public class StringUtils {

    public static final String FORMAT_PARTTEN = "{}";

    public static boolean isNullOrEmpty(String s){
        return s == null || s.length() == 0;
    }

    public static boolean isNotEmpty(String s){
        return !isNullOrEmpty(s);
    }

    public static boolean isNotBlank(String s){
        return isNotEmpty(s) || s.trim().length()!=0;
    }

    public static String format(String format, Object... args){
        if(args == null || args.length == 0){
            return format;
        }

        if(isNullOrEmpty(format) || !format.contains(FORMAT_PARTTEN)){
            return format;
        }

        StringBuilder sbuf = new StringBuilder(format.length() + 50);
        int i = 0;
        int j;
        for(int argsIndex = 0; argsIndex < args.length; argsIndex ++){
            j = format.indexOf(FORMAT_PARTTEN, i);
            if(j > -1) {
                sbuf.append(format,i, j).append(args[argsIndex]);
                i = j + 2;
            }else{
                if(i != 0 && i<format.length()){
                    sbuf.append(format, i, format.length());
                }
            }
        }
        return sbuf.toString();
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

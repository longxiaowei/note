package com.longxw.library.common;

import com.longxw.library.uitl.StringUtils;

/**
 * @author longxw
 * @since 2020/5/13
 */
public class Assert {

    public static void assertTrue(boolean condition, String message, Object... args){
        if(!condition){
            throw new IllegalArgumentException(StringUtils.format(message, args));
        }
    }

    public static void assertNull(Object o, String message, Object... args){
        if(o != null){
            throw new IllegalArgumentException(StringUtils.format(message, args));
        }
    }

    public static void assertNull(Object o){
        if(o != null){
            throw new IllegalArgumentException("the object argument must be null");
        }
    }
}

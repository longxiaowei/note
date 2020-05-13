package com.longxw.library.function;

/**
 * @author longxw
 * @since 2020/5/12
 */
@FunctionalInterface
public interface UncheckPredicate<T> {

    /**
     * 带异常的函数式接口
     * @param t t
     * @return
     * @throws Exception
     */
    boolean test(T t) throws Exception;
}

package com.longxw.library.function;

/**
 * @author longxw
 * @since 2020/5/12
 */
@FunctionalInterface
public interface UncheckFunction<T, R> {

    /**
     * 带异常的函数式接口
     * @param t t
     * @return
     * @throws Exception
     */
    R apply(T t) throws Exception;
}

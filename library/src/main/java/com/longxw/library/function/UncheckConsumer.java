package com.longxw.library.function;


/**
 * @author longxw
 * @since 2020/5/12
 */
@FunctionalInterface
public interface UncheckConsumer<T> {
    /**
     * 带异常的函数式接口
     * @param t t
     * @throws Exception
     */
    void accept(T t) throws Exception;
}

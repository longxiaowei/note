package com.longxw.library.function;

/**
 * @author longxw
 * @since 2020/5/12
 */
@FunctionalInterface
public interface UncheckSupplier<T> {

    /**
     * 带异常的函数式接口
     * @return T
     * @throws Exception
     */
    T get() throws Exception;
}

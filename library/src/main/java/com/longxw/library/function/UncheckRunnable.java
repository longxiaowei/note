package com.longxw.library.function;

@FunctionalInterface
public interface UncheckRunnable {

    /**
     * 带异常的函数式接口
     * @throws Exception
     */
    void run() throws Exception;
}

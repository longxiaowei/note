package com.longxw.graphql.resolver;

import graphql.schema.DataFetchingEnvironment;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author longxw
 * @since 2020/4/8
 */
public abstract class AbstractArgResolver {

    /**
     * 是否支持
     * @param parameter 参数
     * @return
     */
    public abstract boolean supportsParameter(Parameter parameter);

    /**
     * @param method 执行的方法
     * @param parameter 参数名
     * @param environment  DataFetchingEnvironment
     * @return
     */
    public abstract Object get(Method method, Parameter parameter, DataFetchingEnvironment environment);
}

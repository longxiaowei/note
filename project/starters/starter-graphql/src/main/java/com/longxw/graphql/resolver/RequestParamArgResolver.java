package com.longxw.graphql.resolver;

import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLArgument;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author longxw
 * @since 2020/4/8
 */
public class RequestParamArgResolver extends AbstractArgResolver {

    @Override
    public boolean supportsParameter(Parameter parameter) {
        return parameter.getAnnotation(RequestParam.class) != null;
    }

    @Override
    public Object get(Method method, Parameter parameter, DataFetchingEnvironment environment) {
        RequestParam param = parameter.getAnnotation(RequestParam.class);
        String name = parameter.getName();
        if(param.value().length() > 0){
            name = param.value();
        }else if(param.name().length() > 0){
            name = param.name();
        }
        GraphQLArgument argument = environment.getFieldDefinition().getArgument(name);
        if(argument == null){
            throw new RuntimeException("未定义");
        }
        Object value = argument.getValue();
        if(value == null){
            value = argument.getDefaultValue();
        }
        return value;
    }
}

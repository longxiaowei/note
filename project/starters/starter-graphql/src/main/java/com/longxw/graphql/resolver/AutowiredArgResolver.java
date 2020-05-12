package com.longxw.graphql.resolver;

import com.longxw.library.uitl.StringUtils;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author longxw
 * @since 2020/5/12
 */
public class AutowiredArgResolver extends AbstractArgResolver implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public boolean supportsParameter(Parameter parameter) {
        return parameter.getAnnotation(Autowired.class) != null;
    }

    @Override
    public Object get(Method method, Parameter parameter, DataFetchingEnvironment environment) {
        Qualifier qualifier = parameter.getAnnotation(Qualifier.class);
        Autowired autowired = parameter.getAnnotation(Autowired.class);
        Object bean;

        if(qualifier != null && StringUtils.isNotBlank(qualifier.value())){
            bean = applicationContext.getBean(qualifier.value());

            if(bean == null && autowired.required()){
                throw new RuntimeException("期望找到名称为"+ qualifier.value() + "的 bean" + "，但是获取的 bean 为空");
            }

            return bean;
        }

        bean = applicationContext.getBean(parameter.getType());

        if(bean == null && autowired.required()){
            throw new RuntimeException("无法找到 type 为" + parameter.getType() + "的 bean");
        }

        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

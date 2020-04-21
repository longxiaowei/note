package com.longxw.demo;

import lombok.Getter;
import org.springframework.beans.factory.BeanClassLoaderAware;

/**
 * @author longxw
 * @since 2020/4/21
 */
public class TestClassLoader implements BeanClassLoaderAware {

    @Getter
    private ClassLoader classLoader;

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}

package com.longxw.demo;

import lombok.Getter;
import org.springframework.beans.factory.BeanClassLoaderAware;

public class TestClassLoader implements BeanClassLoaderAware {

    @Getter
    private ClassLoader classLoader;

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}

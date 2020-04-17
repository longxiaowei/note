package com.longxw;

import com.longxw.demo.TestClassLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author longxw
 * @since 2020/4/16
 */
@SpringBootApplication
public class TraningApplication {
    public static void main(String[] args) {
        SpringApplication.run(TraningApplication.class, args);
    }

    @Bean
    public TestClassLoader testClassLoader(){
        return new TestClassLoader();
    }
}

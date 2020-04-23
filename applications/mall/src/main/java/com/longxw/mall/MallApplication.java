package com.longxw.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author longxw
 * @since 2020/4/10
 */
@MapperScan("com.longxw.mall.project.mapper")
@SpringBootApplication
@EnableConfigurationProperties
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }
}

package com.longxw.controller;

import com.longxw.demo.TestClassLoader;
import com.longxw.library.uitl.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author longxw
 * @since 2020/4/16
 */
@RestController
public class TestClassLoaderController {

    @Autowired
    TestClassLoader testClassLoader;

    /**
     * 测试 jar 包内部文件读取
     * @return
     * @throws IOException
     */
    @GetMapping("/test")
    public boolean test() throws IOException {
        String file = "test.txt";

        System.out.println("---------- getResourceAsStream-------");
        System.out.println(FileUtils.readBytesAsString(this.getClass().getClassLoader().getResourceAsStream(file)));
        System.out.println(FileUtils.readBytesAsString(Thread.currentThread().getContextClassLoader().getResourceAsStream(file)));
        System.out.println(FileUtils.readBytesAsString(testClassLoader.getClassLoader().getResourceAsStream(file)));

        System.out.println("---------- getResource-------");
        System.out.println(this.getClass().getClassLoader().getResource(file));
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(file));
        System.out.println(testClassLoader.getClassLoader().getResource(file));



        return true;
    }
}

package com.longxw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestDeadlock {


    private Object lock1 = new Object();
    private Object lock2 = new Object();

    /**
     * 死锁
     * */
    @RequestMapping("/deadlock")
    public String testLock() {
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                synchronized (lock2) {
                    System.out.println("Thread1 over");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                synchronized (lock1) {
                    System.out.println("Thread2 over");
                }
            }
        }).start();
        return "deadlock";
    }
}

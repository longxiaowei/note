package com.longxw.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author longxw
 * @since 2020/4/14
 */
public class ReentrantLockDemo {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition conditionA = reentrantLock.newCondition();
    private static Condition conditionB = reentrantLock.newCondition();

    public static volatile int count = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while(count < 100){
                try {
                    reentrantLock.lock();
                    count ++ ;
                    System.out.println(count);
                    conditionB.signal();
                    conditionA.await();
                    reentrantLock.unlock();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        });

        Thread t2 = new Thread(() -> {

            while(count<100){
                try {
                    reentrantLock.lock();
                    count ++ ;
                    System.out.println(count);
                    conditionA.signal();
                    conditionB.await();
                    reentrantLock.unlock();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        });
        t1.start();
        t2.start();
    }


}

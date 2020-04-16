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
                    System.out.println(Thread.currentThread().getId()+" 获得锁:        "+count);
                    conditionB.signal();
                    if(count < 100){
                        conditionA.await();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }
            System.out.println(Thread.currentThread().getId()+" 执行最后一次:        "+count);

        });

        Thread t2 = new Thread(() -> {
            while(count<100){
                try {
                    reentrantLock.lock();
                    count ++ ;
                    System.out.println(Thread.currentThread().getId()+" 获得锁:        "+count);
                    conditionA.signal();
                    if(count < 100){
                        conditionB.await();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }
            System.out.println(Thread.currentThread().getId()+" 执行最后一次:        "+count);
        });
        t1.setName("demo1");
        t2.setName("demo2");
        t1.start();
        t2.start();
    }


}

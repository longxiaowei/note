package com.longxw.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author longxw
 * @since 2020/4/17
 */
@Slf4j
public class SemaphoreTest {



    static class Parking{
        private ExecutorService executorService = Executors.newFixedThreadPool(6);
        private Semaphore semaphore;

        public Parking(int count){
            this. semaphore = new Semaphore(count);
        }

        public void park(){
            try {
                semaphore.acquire();
                executorService.submit(() -> {
                    log.info("{} 进入停车场，停车5s", Thread.currentThread().getName());
                    log.info("{} 开出停车场", Thread.currentThread().getName());
                    try {
                        final Random random = new Random();

                        Thread.sleep(random.nextInt());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }

    }

    public static void main(String[] args) {
        Parking parking = new Parking(2);
        while(true){
            parking.park();
        }
    }

}

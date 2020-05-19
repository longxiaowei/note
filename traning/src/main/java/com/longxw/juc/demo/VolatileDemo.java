package com.longxw.juc.demo;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author longxw
 * @since 2020/5/15
 */
public class VolatileDemo {

    public static int x = 0, y = 0;
    public static int a = 0, b =0;

    private static boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        final Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        //test1();
        //test2();
    }

    /**
     * 测试 线程可见性
     */
    public static void test1() throws InterruptedException {
        new Thread(() -> {
            while(running){
            }
        }).start();

        Thread.sleep(4000);
        running = false;
    }

    /**
     * 测试指令重排序
     */
    public static void test2(){
        int i=0;
        for(;;){
            x = 0; y = 0;
            a = 0; b = 0;
            i++;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    shortWait(100000);
                    a = 1;
                    x = b;
                }
            });

            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start();two.start();
            try {
                one.join();
                two.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String result = "第" + i + "次 (" + x + "," + y + "）";
            if(x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                //System.out.println(result);
            }
        }
    }

    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }
}

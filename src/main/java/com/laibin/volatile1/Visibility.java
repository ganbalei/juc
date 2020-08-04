package com.laibin.volatile1;

import java.util.concurrent.TimeUnit;

/**
 * volatile
 * 保证可见性，不保证原子性，由于内存屏障，可以保证禁止指令重排
 */
public class Visibility {

    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            while (num == 0){
                System.out.println("1111");
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        num = 1;
        System.out.println("2222");
    }
}

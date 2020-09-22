package com.laibin.volatile1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile
 * 不保证原子性
 */
public class Unatomicity {

    // private static int num = 0;
    // private volatile static int num = 0;
    //lock 和 synchronized 保证原子性
    //原子类的Integer 保证原子性
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add(){
        num.getAndIncrement();//是原子性操作
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {//main gc
            Thread.yield();
        }
        System.out.println("num: "+num);
    }
}

package com.laibin.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Executors 工具栏、三大方法
public class ExecutorsDemo {
    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//创建一个固定大小的线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩的，遇强则强，遇弱则弱

        try {
            for (int i = 0; i < 100; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"  OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

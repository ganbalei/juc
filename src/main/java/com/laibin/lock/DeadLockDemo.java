package com.laibin.lock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 * jps -l 查看进程
 * jstack 进程号 查看进程死锁问题
 */
public class DeadLockDemo {
    public static void main(String[] args) {

        String msgContent = String.format("完成进度%d/%d，继续加油@推广任务“转发%s：%s”，去推广>>", 500L, 1000, "直播间", "总部发布新的推广任务，请立即查看");
        System.out.println(msgContent);
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new MyThread(lockA, lockB), "T1").start();
        new Thread(new MyThread(lockB, lockA), "T2").start();
    }
}

class MyThread implements Runnable{

    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"lock:"+ lockA +"=>" + lockB);
            TimeUnit.SECONDS.sleep(2);
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"lock:"+ lockB +"=>" + lockA);
            }
        }
    }
}
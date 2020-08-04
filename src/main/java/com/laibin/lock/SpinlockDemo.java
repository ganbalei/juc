package com.laibin.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinlockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 加锁
    public void myLock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)){
            System.out.println("还未获得锁，自旋ing");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"=>myLock");

    }

    //解锁
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"=>myUnlock");
        atomicReference.compareAndSet(thread, null);
    }
}

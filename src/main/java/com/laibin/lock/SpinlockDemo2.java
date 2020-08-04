package com.laibin.lock;

import java.util.concurrent.TimeUnit;

public class SpinlockDemo2 {
    public static void main(String[] args) throws InterruptedException {
        SpinlockDemo lock = new SpinlockDemo();

        new Thread(()->{
            try {
                lock.myLock();
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.myUnlock();
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            try {
                lock.myLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.myUnlock();
        }).start();
    }
}

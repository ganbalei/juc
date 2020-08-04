package com.laibin.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class ReentrantLock2 {
    private Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        ReentrantLock2 reentrantLock = new ReentrantLock2();

        new Thread(()->{
            reentrantLock.sendSms();
        }, "A").start();

        new Thread(()->{
            reentrantLock.sendSms();
        }, "B").start();
    }

    public void sendSms(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"sendSms");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void call(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

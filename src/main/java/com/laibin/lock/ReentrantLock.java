package com.laibin.lock;

public class ReentrantLock {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(()->{
            reentrantLock.sendSms();
        }, "A").start();

        new Thread(()->{
            reentrantLock.sendSms();
        }, "B").start();
    }

    public synchronized void sendSms(){
        System.out.println(Thread.currentThread().getName()+"sendSms");
        call();
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"call");
    }
}

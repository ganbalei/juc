package com.laibin.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是锁的八个问题
 * 1.标志情况下，两个线程先打印 发短信还是打电话？ 1.发短信  2.打电话
 * 2.sendSMS延迟4秒，两个线程先打印 发短信还是打电话？  1.发短信 2.打电话
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        //锁的存在
        new Thread(()->{phone.sendSms();}, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{phone.call();}, "B").start();
    }
}

class Phone{

    //synchronized 锁的对象是方法的调用者！
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}

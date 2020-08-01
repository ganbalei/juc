package com.laibin.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 7.增加一个静态同步方法，只有一个对象，先打印打电话还是发短信？ 1.打电话 2.发短信
 * 8.增加一个静态同步方法，只有两个对象，先打印打电话还是发短信？ 1.打电话 2.发短信
 */
public class Test4 {

    public static void main(String[] args) {
        Phone4 phone = new Phone4();

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

class Phone4{

    //synchronized 锁的对象是方法的调用者！
    //static 静态方法
    //类一加载就有了，锁的是class
    public static synchronized void sendSms(){
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

package com.laibin.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 5.增加两个静态同步方法，只有一个对象，先打印打电话还是发短信？ 1.发短信 2.打电话
 * 6.两个对象，增加两个静态同步方法，先打印打电话还是发短信？ 1.发短信 2.打电话
 */
public class Test3 {

    public static void main(String[] args) {
        Phone3 phone = new Phone3();
        Phone3 phone2 = new Phone3();

        //锁的存在
        new Thread(()->{phone.sendSms();}, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{phone2.call();}, "B").start();
    }
}

class Phone3{

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

    public static synchronized void call(){
        System.out.println("打电话");
    }
}
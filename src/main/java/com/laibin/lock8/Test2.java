package com.laibin.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 3.增加了一个普通方法，先执行发短信还是hello？ 1.hello  2.发短信
 * 4.两个对象，两个同步方法，发短信还是打电话？ 1.打电话 2. 发短信
 */
public class Test2 {

    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        Phone2 phone2 = new Phone2();

        //锁的存在
        new Thread(()->{phone.sendSms();}, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{phone2.call();}, "B").start();

        new Thread(()->{phone.hello();}, "B").start();
    }
}

class Phone2{

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

    //这里没有锁，不受锁的影响
    public void hello(){
        System.out.println("hello");
    }
}


package com.laibin.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C {
    public static void main(String[] args) {
        Data3 data3 = new Data3();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        }).start();
    }
}

class Data3{

    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    private int number = 1; //1A 2B 3C

    public void printA(){
        try {
            lock.lock();
            while (number != 1)
                condition1.await();
            number = 2;
            System.out.println(Thread.currentThread().getName()+"=>AAAA");
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB(){
        try {
            lock.lock();
            while (number != 2)
                condition2.await();
            number = 3;
            System.out.println(Thread.currentThread().getName()+"=>BBBB");
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC(){
        try {
            lock.lock();
            while (number != 3)
                condition3.await();
            number = 1;
            System.out.println(Thread.currentThread().getName()+"=>CCCC");
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
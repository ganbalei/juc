package com.laibin.pc;

public class A {

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class Data{
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        //当有多个线程同时执行increment时，会存在虚假唤醒问题
//        if (number != 0){
//            this.wait();
//        }
        while (number != 0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);

        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (number == 0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);

        this.notifyAll();
    }
}

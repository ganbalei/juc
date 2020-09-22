package com.laibin.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS ABA问题（狸猫换太子）
 * 解决ABA问题：原子引用
 * 线程一： A -> B
 * 线程二： B -> A
 * 线程三： A -> B
 * Integer问题 -128-127 IntegerCache.cache缓存
 */
public class CASDemo {
    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger(2020);
//        atomicInteger.compareAndSet(2020, 2021);
//        System.out.println(atomicInteger.get());
        AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<>(1, 1);

        new Thread(()->{
            int stamp = integerAtomicStampedReference.getStamp();// 获得版本号
            System.out.println("a1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(integerAtomicStampedReference.compareAndSet(1, 2, integerAtomicStampedReference.getStamp(), integerAtomicStampedReference.getStamp() + 1));
            System.out.println("a2=>"+stamp);
            System.out.println(integerAtomicStampedReference.compareAndSet(2, 1, integerAtomicStampedReference.getStamp(), integerAtomicStampedReference.getStamp() + 1));
            System.out.println("a3=>"+stamp);
        }).start();

        new Thread(()->{
            int stamp = integerAtomicStampedReference.getStamp();
            System.out.println("b1=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(integerAtomicStampedReference.compareAndSet(1, 2, integerAtomicStampedReference.getStamp(), integerAtomicStampedReference.getStamp() + 1));
            System.out.println("b2=>"+stamp);
        }).start();

    }
}

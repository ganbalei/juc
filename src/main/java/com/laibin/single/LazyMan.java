package com.laibin.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

//懒汉式单例模式
public class LazyMan {

    private static boolean flag = false;
    private LazyMan(){
        synchronized (LazyMan.class){
            if (!flag)
                flag = true;
            if (lazyMan != null)
                throw new RuntimeException("不要试图反射破坏单例");
        }
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    private static LazyMan lazyMan;

    public static LazyMan getInstance(){
        // 单线程下安全，多线程下不安全
        // if (lazyMan == null){
        //     lazyMan = new LazyMan();
        // }

        // 双重检测锁模式的懒汉式单例模式 DCL懒汉式
        if (lazyMan == null){
            synchronized (LazyMan.class){
                if (lazyMan == null){
                    lazyMan = new LazyMan();//不是一个原子性操作
                    /**
                     * 1. 给 instance 分配内存
                     * 2. 调用 Singleton 的构造函数来初始化成员变量
                     * 3. 将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
                     * 预期是 123
                     * 可能 132 线程A按照这个顺序执行完成
                     *          线程B此时lazyMan还没有完成构造
                     */
                }
            }
        }
        return lazyMan;
    }

    //反射
    public static void main(String[] args) throws Exception{
        // LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan lazyMan = declaredConstructor.newInstance();
        Field flag = LazyMan.class.getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(lazyMan, false);
        LazyMan lazyMan1 = declaredConstructor.newInstance();

        System.out.println(lazyMan);
        System.out.println(lazyMan1);
    }
}

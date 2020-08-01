package com.laibin.unsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {

    public static void main(String[] args) {
        //java.util.ConcurrentModificationException 并发修改异常
        //并发下ArrayList不安全的， synchronized
        /**
         * 解决方案：
         * 1、List<String> list = new Vector<>();
         * 2、List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3、List<String> list = new CopyOnWriteArrayList<>();
         */
        //CopyOnWriteArrayList 写入时复制，COW 计算机程序设计领域的一种优化策略
        //多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
        //在写入的时候避免覆盖，造成数据问题

        /**
         *  CopyOnWriteArrayList 比 Vector厉害在那里：
         *  1.Vector的add方法用的是synchronized，CopyOnWriteArrayList的add方法调用lock和copyOf，效率更高
         */

        List<String> list = new CopyOnWriteArrayList<>();
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}

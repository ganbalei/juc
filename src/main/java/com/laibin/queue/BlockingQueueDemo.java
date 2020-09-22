package com.laibin.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    /**
     * 抛出异常
     */
    public static void test(){
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(3);

        System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));
        //IllegalStateException: Queue full  使用add会抛出异常
        //System.out.println(queue.add("d"));
        //返回队首元素
        System.out.println(queue.element());

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //NoSuchElementException 使用remove会抛出异常
        //System.out.println(queue.remove());
    }

    /**
     * 有返回值，不抛出异常
     */
    public static void test1(){
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(3);

        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
        //超出范围，返回false，不抛出异常
        System.out.println(queue.offer("d"));
        //返回队首元素
        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        //返回null，不抛出异常
        System.out.println(queue.poll());
    }

    /**
     * 等待，阻塞
     * @throws InterruptedException
     */
    public static void test2() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(3);

        queue.put("a");
        queue.put("b");
        queue.put("c");
        queue.put("c");

        //返回队首元素
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        //返回null，不抛出异常
        System.out.println(queue.poll());
    }

    public static void test3() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(3);

        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
        //设置超时时间，超出就退出
        System.out.println(queue.offer("d", 2, TimeUnit.SECONDS));
        //返回队首元素
        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
    }
}

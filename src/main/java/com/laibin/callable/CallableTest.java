package com.laibin.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    /**
     * FutureTask继承了RunnableFuture接口， RunnableFuture接口继承了Runnable接口
     * FutureTask的构造方法入参为Callable
     * public FutureTask(Callable<V> callable)；
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);
        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();//结果会有缓存效率高

        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("调用了call方法");
        return 1024;
    }
}

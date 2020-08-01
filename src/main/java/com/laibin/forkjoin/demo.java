package com.laibin.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1(); // 364
        //test2(); // 4452
        test3(); // 221
    }

    public static void test1(){
        long start = System.currentTimeMillis();
        long sum = 0;
        for (long i = 1; i <= 10_0000_0000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum= "+sum+" 时间："+(end-start));
    }

    //forkjoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new Forkjoin(1L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();

        long end = System.currentTimeMillis();
        System.out.println("sum= "+sum+" 时间："+(end-start));
    }

    // stream并行流
    public static void test3(){
        long start = System.currentTimeMillis();


        long sum = LongStream.rangeClosed(1L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum= "+sum+" 时间："+(end-start));
    }
}

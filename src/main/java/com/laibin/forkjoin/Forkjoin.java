package com.laibin.forkjoin;

import java.util.concurrent.RecursiveTask;

public class Forkjoin extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    private Long temp = 10000L;

    public Forkjoin(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if ((end-start) <temp){
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else {
            Long middle = (start+end)/2;
            Forkjoin forkjoin = new Forkjoin(start, middle);
            forkjoin.fork(); //拆分任务，把任务压入线程队列
            Forkjoin forkjoin1 = new Forkjoin(middle+1, end);
            forkjoin1.fork();

            return forkjoin.join() + forkjoin1.join();
        }

    }
}

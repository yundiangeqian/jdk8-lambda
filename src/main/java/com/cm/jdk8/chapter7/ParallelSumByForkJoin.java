package com.cm.jdk8.chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/7 8:45
 */
public class ParallelSumByForkJoin extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start;
    private final int end;


    public static final long threshold = 10000L;

    public ParallelSumByForkJoin(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public ParallelSumByForkJoin(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= threshold) {
            return computeSum();
        }
        ParallelSumByForkJoin leftTask = new ParallelSumByForkJoin(numbers, start, start + length / 2);
        //异步执行新的子任务
        leftTask.fork();

        ParallelSumByForkJoin rightTask = new ParallelSumByForkJoin(numbers, start + length / 2, end);
        //同步执行
        long rightResult = rightTask.compute();

        long leftResult = leftTask.join();
        return rightResult + leftResult;
    }

    private long computeSum() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> currentTask = new ParallelSumByForkJoin(numbers);
        return new ForkJoinPool().invoke(currentTask);
    }
}

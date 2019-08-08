package com.cm.jdk8.chapter7;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/6 17:35
 */
public class Parallel {
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long parallelRangeSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            System.out.println(sum);
            long duration = (System.nanoTime() - start) / 1000000;
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

}

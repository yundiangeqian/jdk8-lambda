package com.cm.jdk8.chapter7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.LongStream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ParallelSumByForkJoinTest {
    private static final Logger logger = LoggerFactory.getLogger(ParallelSumByForkJoinTest.class);

    @Test
    public void testForkJoinSum() {
        long sum = ParallelSumByForkJoin.forkJoinSum(50000);
        logger.info("分支/合并并行求和:{}", sum);
    }

    @Test
    public void test() {
        long sum = LongStream.rangeClosed(1, 6250).boxed().reduce(0L, Long::sum);
        long sum1 = LongStream.rangeClosed(6251, 12500).boxed().reduce(0L, Long::sum);
        long sum2 = LongStream.rangeClosed(12501, 18750).boxed().reduce(0L, Long::sum);
        long sum3 = LongStream.rangeClosed(18751, 25000).boxed().reduce(0L, Long::sum);
        long sum4 = LongStream.rangeClosed(25001, 31250).boxed().reduce(0L, Long::sum);
        long sum5 = LongStream.rangeClosed(31251, 37500).boxed().reduce(0L, Long::sum);
        long sum6 = LongStream.rangeClosed(37501, 43750).boxed().reduce(0L, Long::sum);
        long sum7 = LongStream.rangeClosed(43751, 50000).boxed().reduce(0L, Long::sum);
        System.out.println(sum);
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(sum4);
        System.out.println(sum5);
        System.out.println(sum6);
        System.out.println(sum7);
    }
}
package com.cm.jdk8.chapter7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ParallelTest {
    private static final Logger logger = LoggerFactory.getLogger(ParallelTest.class);

    @Test
    public void testParallelSum() {
        logger.info("iterative并行处理：{}", Parallel.measureSumPerf(Parallel::parallelSum, 10000000L));
    }

    @Test
    public void testParallelRangeSum() {
        logger.info("range并行处理：{}", Parallel.measureSumPerf(Parallel::parallelRangeSum, 10000000L));
    }

}
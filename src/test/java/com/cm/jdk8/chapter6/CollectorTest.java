package com.cm.jdk8.chapter6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/6 15:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CollectorTest {
    private static final Logger logger = LoggerFactory.getLogger(CollectorTest.class);

    @Test
    public void test() {
        Map<Boolean, List<Integer>> primes = IntStream.rangeClosed(2, 100).boxed().collect(new PrimeCollector());
        logger.info("素数：{}", primes.get(true));
    }
}

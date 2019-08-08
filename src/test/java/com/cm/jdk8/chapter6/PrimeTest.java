package com.cm.jdk8.chapter6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/6 14:58
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PrimeTest {
    private static final Logger logger = LoggerFactory.getLogger(PrimeTest.class);

    private boolean isPrime(int param) {
        int paramRoot = (int) Math.sqrt((double) param);
        return IntStream.rangeClosed(2, paramRoot).noneMatch(i -> param % i == 0);
    }

    @Test
    public void testIsPrime() {
        Map<Boolean, List<Integer>> prime = IntStream.rangeClosed(2, 100).boxed().collect(partitioningBy(integer -> isPrime(integer)));
        logger.info("素数：{}", prime.get(true));

    }
}

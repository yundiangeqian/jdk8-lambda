package com.cm.jdk8.chapter2;

import com.alibaba.fastjson.JSON;
import com.cm.jdk8.entity.Apple;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class FilterTest {
    private static final Logger logger = LoggerFactory.getLogger(Filter.class);

    @Test
    public void testFilter() {
        List<Apple> apples = new ArrayList<>();
        for (int i = 1; i < 1000000; i++) {
            apples.add(new Apple(i, "green", new BigDecimal(i + 1)));
        }
        List<Apple> result = Filter.filter(apples, (Apple apple) -> "green".equals(apple.getColor()));
        logger.info("result:{}", JSON.toJSONString(result));
//        List<Apple>   result = apples.parallelStream().filter((Apple apple) -> "green".equals(apple.getColor())).collect(Collectors.toList());
//        logger.info("result:{}", JSON.toJSONString(result));
    }
}
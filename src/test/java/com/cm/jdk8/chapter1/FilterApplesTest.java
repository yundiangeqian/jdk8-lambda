package com.cm.jdk8.chapter1;

import com.alibaba.fastjson.JSON;
import com.cm.jdk8.constant.TestConstant;
import com.cm.jdk8.entity.Apple;
import com.cm.jdk8.init.InitAppleData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilterApplesTest {

    private static final Logger logger = LoggerFactory.getLogger(FilterApplesTest.class);

    @Test
    public void testFilterApples() {
        List<Apple> appleList = InitAppleData.initData();

        //匿名lambda
        List<Apple> color = FilterApples.filterApples(appleList, (Apple apple) -> "green".equals(apple.getColor()));
        List<Apple> color1 = FilterApples.filterApples(appleList, (Apple apple) -> !"green".equals(apple.getColor()) || apple.getWeight().compareTo(new BigDecimal(150)) == TestConstant.RESULT_NEGATIVE_ONE);
        List<Apple> weight = FilterApples.filterApples(appleList, (Apple apple) -> apple.getWeight().compareTo(new BigDecimal(150)) == TestConstant.RESULT_ONE);
        logger.info("color:{}---weight:{}---color1:{}", JSON.toJSONString(color), JSON.toJSONString(weight), JSON.toJSONString(color1));
        //传递方法
        color = FilterApples.filterApples(appleList, FilterApples::isGreenApple);
        weight = FilterApples.filterApples(appleList, FilterApples::isHeavyApple);
        logger.info("color:{}---weight:{}", JSON.toJSONString(color), JSON.toJSONString(weight));
    }

    @Test
    public void testStream() {
        List<Apple> appleList = InitAppleData.initData();
        Predicate<Apple> weightOver150 = apple -> apple.getWeight().compareTo(new BigDecimal(150)) == TestConstant.RESULT_ONE;
        //顺序处理
        List<String> color = appleList.stream().filter(weightOver150.negate()).sorted(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor).reversed()).map(Apple::getColor).limit(2).collect(Collectors.toList());
        logger.info("color:{}", JSON.toJSONString(color));
    }

    @Test
    public void testParallelStream() {
        List<Apple> appleList = InitAppleData.initData();
        //并行处理
        List<Apple> color = appleList.parallelStream().filter(apple -> "green".equals(apple.getColor())).sorted(Comparator.comparing(Apple::getWeight)).collect(Collectors.toList());
        logger.info("color:{}", JSON.toJSONString(color));
    }

}
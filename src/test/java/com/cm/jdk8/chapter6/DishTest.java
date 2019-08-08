package com.cm.jdk8.chapter6;

import com.alibaba.fastjson.JSON;
import com.cm.jdk8.entity.Dish;
import com.cm.jdk8.init.InitDishData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/6 9:21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DishTest {
    private static final Logger logger = LoggerFactory.getLogger(Dish.class);


    private Stream<Dish> menu() {
        return InitDishData.initData().stream();
    }

    @Test
    public void testCollect() {
        Integer totalCalories = menu().mapToInt(Dish::getCalories).sum();
        logger.info("特定流sum方式菜单总热量：{}", totalCalories);

        totalCalories = menu().collect(summingInt(Dish::getCalories));
        logger.info("collect-summingInt方式菜单总热量：{}", totalCalories);

        totalCalories = menu().collect(reducing(0, Dish::getCalories, Integer::sum));
        logger.info("collect-reducing方式菜单总热量：{}", totalCalories);

        IntSummaryStatistics statistics = menu().collect(summarizingInt(Dish::getCalories));
        logger.info("collect方式菜单热量数据信息统计：{}", statistics);
        logger.info("collect方式菜单热量数据信息统计--菜单元素：{}", statistics.getCount());
        logger.info("collect方式菜单热量数据信息统计--菜单总热量：{}", statistics.getSum());
        logger.info("collect方式菜单热量数据信息统计--菜单最大热量：{}", statistics.getMax());
        logger.info("collect方式菜单热量数据信息统计--菜单最小热量：{}", statistics.getMin());
        logger.info("collect方式菜单热量数据信息统计--菜单热量平均值：{}", statistics.getAverage());
    }

    @Test
    public void testJioning() {
        String menuElements = menu().map(Dish::getName).collect(joining(", "));
        logger.info("菜单元素：{}", menuElements);
    }

    @Test
    public void testDishMaxCalories() {
        Dish dish = menu().max(Comparator.comparing(Dish::getCalories)).orElse(new Dish());
        logger.info("热量最高的菜：{}", JSON.toJSONString(dish));
        Optional<Dish> optional = menu().collect(reducing((dish1, dish2) -> dish1.getCalories() > dish2.getCalories() ? dish1 : dish2));
        logger.info("collect方式-热量最高菜：{}", JSON.toJSONString(optional.orElse(new Dish())));
    }

    @Test
    public void testGroupBy() {
        Map<Dish.Type, List<Dish>> type = menu().collect(groupingBy(Dish::getType));
        logger.info("按类型分组：{}", JSON.toJSONString(type));

        Map<Dish.Type, Long> typeCount = menu().collect(groupingBy(Dish::getType, counting()));
        logger.info("每类型元素数量：{}", JSON.toJSONString(typeCount));

        Map<Dish.CaloricLevel, List<Dish>> caloricLevel = menu().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                }));
        logger.info("按热量分组：{}", JSON.toJSONString(caloricLevel));

        Map<Dish.CaloricLevel, Long> caloricLevelCount = menu().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                }, counting()));
        logger.info("每阶段热量元素数量：{}", JSON.toJSONString(caloricLevelCount));

        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> twoLevel = menu().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
            else return Dish.CaloricLevel.FAT;
        })));
        logger.info("按类型和热量多级分组：{}", JSON.toJSONString(twoLevel));

        Map<Dish.Type, Map<Dish.CaloricLevel, Long>> twoLevelCount = menu().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
            else return Dish.CaloricLevel.FAT;
        }, counting())));
        logger.info("按类型和热量多级分组的各组数量：{}", JSON.toJSONString(twoLevelCount));

        Map<Dish.Type, Dish> typeMaxCalories = menu().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), dish -> dish.orElse(new Dish()))));
        logger.info("按类型分组后各组的最高热量：{}", typeMaxCalories);

        Map<Dish.Type, Integer> sumByType = menu().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        logger.info("按类型求总热量：{}", sumByType);

        Map<Dish.Type, Set<Dish.CaloricLevel>> caloriesLevelByType = menu().collect(groupingBy(Dish::getType, mapping(dish -> {
            if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
            else return Dish.CaloricLevel.FAT;
        }, toCollection(HashSet::new))));
        logger.info("每种类型的热量级别：{}", caloriesLevelByType);
    }

    @Test
    public void testPartitioning() {
        Map<Boolean, List<Dish>> partitioning = menu().collect(partitioningBy(Dish::isVegetarian));
        logger.info("按是否素食分区：{}", partitioning);

        Map<Boolean, Map<Dish.Type, List<Dish>>> partitionType = menu().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        logger.info("分区后各区的类型：{}", partitionType);

    }

}

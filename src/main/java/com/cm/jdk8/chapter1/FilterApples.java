package com.cm.jdk8.chapter1;

import com.cm.jdk8.constant.TestConstant;
import com.cm.jdk8.entity.Apple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description: 删选苹果
 * @author: caomianS
 * @data: 2019/7/31 9:20
 */
public class FilterApples {
    /* *
     * @description: 判断苹果是否为绿苹果
     * @author: caomian
     * @param: [apple]
     * @return: boolean
     * @date: 2019/7/31 9:47
     */
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    /* *
     * @description: 判断苹果是否超过150g
     * @author: caomian
     * @param: [apple]
     * @return: boolean
     * @date: 2019/7/31 9:48
     */
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight().compareTo(new BigDecimal(150)) == TestConstant.RESULT_ONE;
    }

    /* *
     * @description: 根据方法引入传递条件筛选苹果
     * @author: caomian
     * @param: [appleList, condition]
     * @return: java.util.List<com.cm.jdk8.entity.Apple>
     * @date: 2019/7/31 9:57
     */
    public static List<Apple> filterApples(List<Apple> appleList, Predicate<Apple> condition) {
        List<Apple> apples = new ArrayList<>();
        for (Apple apple : appleList) {
            if (condition.test(apple)) {
                apples.add(apple);
            }
        }
        return apples;
    }
}

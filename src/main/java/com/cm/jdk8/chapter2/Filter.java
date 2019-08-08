package com.cm.jdk8.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description: 集合删选类
 * @author: caomian
 * @data: 2019/7/31 15:02
 */
public class Filter {

    /* *
     * @description: 集合的删选
     * @author: caomian
     * @param: [lists, p]
     * @return: java.util.List<T>
     * @date: 2019/7/31 15:10
     */
    public static <T> List<T> filter(List<T> lists, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : lists) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

}

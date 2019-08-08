package com.cm.jdk8.init;

import com.cm.jdk8.entity.Apple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/1 10:16
 */
public class InitAppleData {
    public static List<Apple> initData() {
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple(1, "green", new BigDecimal(160)));
        appleList.add(new Apple(2, "red", new BigDecimal(140)));
        appleList.add(new Apple(3, "yellow", new BigDecimal(155)));
        appleList.add(new Apple(4, "green", new BigDecimal(130)));
        appleList.add(new Apple(5, "green", new BigDecimal(140)));
        return appleList;
    }
}

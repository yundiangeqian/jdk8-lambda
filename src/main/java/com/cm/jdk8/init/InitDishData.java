package com.cm.jdk8.init;

import com.cm.jdk8.entity.Dish;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/6 9:06
 */
public class InitDishData {
    public static List<Dish> initData() {
        List<Dish> dishes = new ArrayList<>();
        Dish dish1 = new Dish("pork", false, 800, Dish.Type.MEAT);
        Dish dish2 = new Dish("beef", false, 700, Dish.Type.MEAT);
        Dish dish3 = new Dish("chicken", false, 400, Dish.Type.MEAT);
        Dish dish4 = new Dish("french fries", true, 530, Dish.Type.OTHER);
        Dish dish5 = new Dish("rice", true, 350, Dish.Type.OTHER);
        Dish dish6 = new Dish("season fruit", true, 120, Dish.Type.OTHER);
        Dish dish7 = new Dish("pizza", true, 550, Dish.Type.OTHER);
        Dish dish8 = new Dish("prawns", false, 400, Dish.Type.FISH);
        Dish dish9 = new Dish("salmon", false, 450, Dish.Type.FISH);
        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        dishes.add(dish4);
        dishes.add(dish5);
        dishes.add(dish6);
        dishes.add(dish7);
        dishes.add(dish8);
        dishes.add(dish9);
        return dishes;
    }
}

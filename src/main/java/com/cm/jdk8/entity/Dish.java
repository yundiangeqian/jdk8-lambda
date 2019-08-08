package com.cm.jdk8.entity;

import java.lang.reflect.Type;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/6 9:02
 */
public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    public Dish() {
    }

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {MEAT, FISH, OTHER}

    public enum CaloricLevel {DIET, NORMAL, FAT}

    @Override
    public String toString() {
        return name;
    }
}

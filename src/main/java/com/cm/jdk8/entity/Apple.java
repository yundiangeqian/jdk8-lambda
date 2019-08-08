package com.cm.jdk8.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description:
 * @author: caomian
 * @data: 2019/7/31 9:22
 */
public class Apple implements Serializable {
    private int id;
    private String color;
    private BigDecimal weight;

    public Apple(int id, String color, BigDecimal weight) {
        this.id = id;
        this.color = color;
        this.weight = weight;
    }

    public Apple() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}

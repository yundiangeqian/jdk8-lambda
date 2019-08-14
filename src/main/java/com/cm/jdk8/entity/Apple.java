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
        return this.id;
    }

    public String getColor() {
        return this.color;
    }

    public BigDecimal getWeight() {
        return this.weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple(id=" + this.getId() + ", color=" + this.getColor() + ", weight=" + this.getWeight() + ")";
    }
}

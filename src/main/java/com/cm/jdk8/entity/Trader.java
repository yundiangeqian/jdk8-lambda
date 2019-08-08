package com.cm.jdk8.entity;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/2 14:39
 */
public class Trader {
    /**
     * traderId
     */
    private Integer traderId;
    /**
     * 商人姓名
     */
    private String name;
    /**
     * 商人来自城市
     */
    private String city;

    public Trader(Integer traderId, String name, String city) {
        this.traderId = traderId;
        this.name = name;
        this.city = city;
    }

    public Integer getTraderId() {
        return traderId;
    }

    public void setTraderId(Integer traderId) {
        this.traderId = traderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

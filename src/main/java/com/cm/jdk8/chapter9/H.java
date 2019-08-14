package com.cm.jdk8.chapter9;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/14 16:15
 */
public class H implements A, G {
    @Override
    public void hello() {
        G.super.hello();
    }

    @Override
    public Integer getNumber() {
        return G.super.getNumber();
    }

}

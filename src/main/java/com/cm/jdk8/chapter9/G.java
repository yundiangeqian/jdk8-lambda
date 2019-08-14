package com.cm.jdk8.chapter9;

/**
 * @description:
 * @author:caomian
 * @data:2019/8/14 16:14
 */
public interface G {
    default void hello() {
        System.out.println("hello from G");
    }

    default Integer getNumber() {
        return 45;
    }
}

package com.cm.jdk8.chapter9;

/**
 * @description:
 * @author:caomian
 * @data:2019/8/14 15:40
 */
public interface B extends A {
    @Override
    default void hello() {
        System.out.println("hello from B");
    }

}

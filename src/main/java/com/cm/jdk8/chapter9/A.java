package com.cm.jdk8.chapter9;

/**
 * @description:
 * @author:caomian
 * @data:2019/8/14 15:38
 */
public interface A {
    default void hello() {
        System.out.println("hello from A");
    }

    default  Number getNumber(){
        return 10;
    }
}

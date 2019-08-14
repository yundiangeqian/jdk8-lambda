package com.cm.jdk8.chapter9;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/14 15:56
 */
public class F extends D implements A, B {
    @Override
    public void hello() {
        System.out.println("hello from F");
    }
}

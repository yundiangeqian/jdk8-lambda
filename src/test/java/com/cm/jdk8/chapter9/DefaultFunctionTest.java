package com.cm.jdk8.chapter9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/14 15:51
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DefaultFunctionTest {
    @Test
    public void cTest() {
        new C().hello();
    }

    @Test
    public void eTest() {
        new E().hello();
    }

    @Test
    public void fTest() {
        new F().hello();
    }

    @Test
    public void gTest() {
        H h = new H();
        h.hello();
        System.out.println(h.getNumber());
    }

}

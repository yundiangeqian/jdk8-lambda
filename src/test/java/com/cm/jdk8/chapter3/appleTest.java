package com.cm.jdk8.chapter3;

import com.alibaba.fastjson.JSON;
import com.cm.jdk8.chapter2.Filter;
import com.cm.jdk8.constant.TestConstant;
import com.cm.jdk8.entity.Apple;
import com.cm.jdk8.init.InitAppleData;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class appleTest {
    private static final Logger logger = LoggerFactory.getLogger(appleTest.class);

    @Test
    public void testSort() {
        List<Apple> appleList = InitAppleData.initData();
        //appleList.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
        //Lambda表达式
        appleList.sort(Comparator.comparing(apple -> apple.getWeight()));
        logger.info("sort after:{}", JSON.toJSONString(appleList));
        //方法引用
        appleList.sort(Comparator.comparing(Apple::getWeight));
        logger.info("sort after:{}", JSON.toJSONString(appleList));
        //比较器复合---逆序、比较器链
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        logger.info("sort after:{}", JSON.toJSONString(appleList));
    }

    @Test
    public void testPredicate() {
        //谓词复合
        List<Apple> appleList = InitAppleData.initData();
        Predicate<Apple> weightBeyond150 = apple -> apple.getWeight().compareTo(new BigDecimal(150)) == TestConstant.RESULT_ONE;
        List<Apple> apples = Filter.filter(appleList, weightBeyond150.negate().and(apple -> "red".equals(apple.getColor())).or(apple -> "yellow".equals(apple.getColor())));
        logger.info("color{}", JSON.toJSONString(apples));
    }

    @Test
    public void testFunction(){
        //函数复合
        Function<String,String> header = Letter::addHeader;
        Function<String,String> footer = Letter::addFooter;
        //先将参数"tony"传入给调用andThen方法的header函数，再将header函数的结果传给andThen方法的footer函数的参数，得到返回值
        Function<String,String> transformationPipeline =header.andThen(footer);
        String text = transformationPipeline.apply("tony");
        logger.info("text:\r\n{}",text);
    }

}
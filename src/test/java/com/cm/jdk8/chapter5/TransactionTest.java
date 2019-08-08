package com.cm.jdk8.chapter5;

import com.alibaba.fastjson.JSON;
import com.cm.jdk8.entity.Trader;
import com.cm.jdk8.entity.Transaction;
import com.cm.jdk8.init.InitTraderAndTransaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/2 15:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionTest {
    private static final Logger logger = LoggerFactory.getLogger(TransactionTest.class);

    @Test
    public void test1() {
        List<Transaction> list = InitTraderAndTransaction.transactions().stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getTransactionAmount)).collect(Collectors.toList());
        logger.info("2011年所有交易按交易额升序：{}", JSON.toJSONString(list));
    }

    @Test
    public void test2() {
        List<String> list = InitTraderAndTransaction.transactions().stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
        logger.info("商人活动过的城市：{}", JSON.toJSONString(list));
    }

    @Test
    public void test3() {
        List<Trader> list = InitTraderAndTransaction.transactions().stream().map(Transaction::getTrader).filter(trader -> "Cambridge".equals(trader.getCity())).distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        logger.info("按姓名排序来自剑桥的交易员：{}", JSON.toJSONString(list));
    }

    @Test
    public void test4() {
        Optional<String> str = InitTraderAndTransaction.transactions().stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce(String::concat);
        logger.info("按字母顺序排序，返回所有交易员的姓名字符串：{}", str);
    }

    @Test
    public void test5() {
        boolean result = InitTraderAndTransaction.transactions().stream().map(Transaction::getTrader).anyMatch(trader -> "Milan".equals(trader.getCity()));
        logger.info("有没有米兰的交易员：{}", result);
    }

    @Test
    public void test6() {
        InitTraderAndTransaction.transactions().stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).map(transaction -> transaction.getTransactionAmount()).forEach(System.out::println);
    }

    @Test
    public void test7() {
        Optional<Integer> result = InitTraderAndTransaction.transactions().stream().map(transaction -> transaction.getTransactionAmount()).reduce(Integer::max);
        logger.info("剑桥交易员中的最高交易额：{}", result);
    }

    @Test
    public void test8() {
        //  Optional<Transaction> result = InitTraderAndTransaction.transactions().stream().reduce((transaction, transaction2) -> transaction.getTransactionAmount() < transaction2.getTransactionAmount() ? transaction : transaction2);
        Optional<Transaction> result = InitTraderAndTransaction.transactions().stream().min(Comparator.comparing(Transaction::getTransactionAmount));
        logger.info("剑桥交易员中的最小交易：{}", JSON.toJSONString(result));
    }
}

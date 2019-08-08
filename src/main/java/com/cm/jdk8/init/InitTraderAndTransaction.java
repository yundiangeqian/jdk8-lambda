package com.cm.jdk8.init;

import com.cm.jdk8.entity.Trader;
import com.cm.jdk8.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/2 14:53
 */
public class InitTraderAndTransaction {
    public static List<Transaction> transactions() {
        Trader mark = new Trader(1, "mark", "Cambridge");
        Trader tony = new Trader(2, "tony", "Milan");
        Trader jemy = new Trader(3, "jemy", "Cambridge");
        Trader lucas = new Trader(4, "lucas", "Cambridge");
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, lucas, 2011, 300));
        transactions.add(new Transaction(2, mark, 2012, 1000));
        transactions.add(new Transaction(3, mark, 2011, 400));
        transactions.add(new Transaction(4, tony, 2012, 710));
        transactions.add(new Transaction(5, tony, 2012, 700));
        transactions.add(new Transaction(6, jemy, 2012, 950));
        return transactions;
    }
}

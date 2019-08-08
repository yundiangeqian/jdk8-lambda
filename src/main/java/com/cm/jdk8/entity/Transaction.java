package com.cm.jdk8.entity;

/**
 * @description:
 * @author: caomian
 * @data: 2019/8/2 14:45
 */
public class Transaction {
    /**
     * 交易id
     */
    private Integer transactionId;
    /**
     * 交易商人
     */
    private Trader trader;
    /**
     * 交易产生的年份
     */
    private Integer year;
    /**
     * 年交易额
     */
    private Integer transactionAmount;

    public Transaction(Integer transactionId, Trader trader, Integer year, Integer transactionAmount) {
        this.transactionId = transactionId;
        this.trader = trader;
        this.year = year;
        this.transactionAmount = transactionAmount;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Integer transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}

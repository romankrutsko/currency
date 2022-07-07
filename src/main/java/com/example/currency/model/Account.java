package com.example.currency.model;

public class Account {
    private Integer id;
    private Integer userId;
    private Double balance;
    private String currentCurrency;

    public Account() {

    }

    public Account(Integer id, Integer userId, Double balance, String currentCurrency) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.currentCurrency = currentCurrency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrentCurrency() {
        return currentCurrency;
    }

    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }
}

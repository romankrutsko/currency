package com.example.currency.model;

public class Account {
    private Double balance;
    private String currentCurrency;

    public Account(Double balance, String currentCurrency) {
        this.balance = balance;
        this.currentCurrency = currentCurrency;
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

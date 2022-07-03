package com.example.currency.model;

public class User {
    private Integer id;
    private String name;
    private Account account;

    public User(Integer id, String name, Account account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

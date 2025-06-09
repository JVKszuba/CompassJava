package model.entities;

import model.exceptions.BusinessException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    //Constructors
    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {

        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    //Getters and setters methods
    public Integer getNumber() {return number;}
    public String getHolder() {return holder;}
    public Double getBalance() {return balance;}
    public Double getWithdrawLimit() {return withdrawLimit;}

    public void setHolder(String holder) {this.holder = holder;}
    public void setWithdrawLimit(Double withdrawLimit) {this.withdrawLimit = withdrawLimit;}

    //General methods
    public void deposit(Double amount) {

        this.balance += amount;
    }

    public void withdraw(Double amount) throws BusinessException {

        if (amount > this.withdrawLimit) throw new BusinessException("The amount exceeds withdraw limit");
        if (amount > this.balance) throw new BusinessException("Not enough balance");

        this.balance -= amount;
    }
}

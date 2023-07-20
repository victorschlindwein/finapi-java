package com.br.victorschlindwein.finapi.models;

import com.br.victorschlindwein.finapi.models.exceptions.InsufficientFundsException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Account {
    private Customer customer;
    private int agency;
    private int number;
    private BigDecimal balance = BigDecimal.ZERO;

    public Account(){
    }

    public Account(Customer customer, int agency, int number){
        Objects.requireNonNull(customer);
        this.customer = customer;
        this.agency = agency;
        this.number = number;
    }

    public void deposit(BigDecimal value){
        if(value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior do que zero");
        }

        balance = balance.add(value);
    }

    public void withdraw(BigDecimal value){
        if(value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor deve ser maior do que zero");
        }

        if(getAvaiableBalance().subtract(value).compareTo(BigDecimal.ZERO) < 0){
            throw new InsufficientFundsException("Saldo insuficiente");
        }

        balance = balance.subtract(value);
    }

    public void withdraw(BigDecimal value, BigDecimal tax){
        withdraw(value.add(tax));
    }

    public abstract void debitMonthlyFee(BigDecimal fee);

    public Customer getCustomer() {
        return customer;
    }

    public int getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public BigDecimal getAvaiableBalance(){
        return getBalance();
    }
}

package com.br.victorschlindwein.finapi.models;

import com.br.victorschlindwein.finapi.models.exceptions.InsufficientFundsException;

import java.util.Objects;

public abstract class Account {
    private Customer customer;
    private int agency;
    private int number;
    private double balance;

    public Account(){
    }

    public Account(Customer customer, int agency, int number){
        Objects.requireNonNull(customer);
        this.customer = customer;
        this.agency = agency;
        this.number = number;
    }

    public void deposit(double value){
        if(value <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior do que zero");
        }

        balance = balance + value;
    }

    public void withdraw(double value){
        if(value <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior do que zero");
        }

        if(getAvaiableBalance() - value < 0){
            throw new InsufficientFundsException("Saldo insuficiente");
        }

        balance = balance - value;
    }

    public void withdraw(double value, double tax){
        withdraw(value + tax);
    }

    public abstract void debitMonthlyFee(double fee);

    public Customer getCustomer() {
        return customer;
    }

    public int getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }
    public double getAvaiableBalance(){
        return getBalance();
    }
}

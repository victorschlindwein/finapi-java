package com.br.victorschlindwein.finapi.models;

import java.util.Objects;

public class Account {
    private Customer customer;
    private final int agency;
    private final int number;
    private double balance;

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

        if(balance - value < 0){
            throw new IllegalStateException("Saldo insuficiente");
        }

        balance = balance - value;
    }

    public void withdraw(double value, double tax){
        withdraw(value + tax);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
}

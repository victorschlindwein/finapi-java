package com.br.victorschlindwein.finapi.models;

public class InvestmentAccount extends Account {
    public InvestmentAccount(Customer customer, int agency, int number){
        super(customer, agency, number);
    }

    public void addInterest(double interestRate){
        double interestValue = getBalance() * interestRate / 100;
        deposit(interestValue);
    }
}

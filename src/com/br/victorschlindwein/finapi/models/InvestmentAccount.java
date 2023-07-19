package com.br.victorschlindwein.finapi.models;

public class InvestmentAccount extends Account {
    public InvestmentAccount(Customer customer, int agency, int number){
        super(customer, agency, number);
    }

    @Override
    public void debitMonthlyFee(double fee) {
        if (getBalance() < 10_000) {
            withdraw(fee);
        }
    }

    public void addInterest(double interestRate){
        double interestValue = getBalance() * interestRate / 100;
        deposit(interestValue);
    }
}

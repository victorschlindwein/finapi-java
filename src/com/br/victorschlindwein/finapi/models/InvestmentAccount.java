package com.br.victorschlindwein.finapi.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestmentAccount extends Account {
    public InvestmentAccount(Customer customer, int agency, int number){
        super(customer, agency, number);
    }

    @Override
    public void debitMonthlyFee(BigDecimal fee) {
        if (getBalance().compareTo(new BigDecimal("10000")) < 0) {
            withdraw(fee);
        }
    }

    public void addInterest(BigDecimal interestRate){
        BigDecimal interestValue = getBalance().multiply(interestRate)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_EVEN);
        deposit(interestValue);
    }
}

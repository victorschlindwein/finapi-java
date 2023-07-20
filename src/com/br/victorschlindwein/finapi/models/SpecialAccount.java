package com.br.victorschlindwein.finapi.models;

import java.math.BigDecimal;

public class SpecialAccount extends Account {
    private BigDecimal limitValue;
    public SpecialAccount(Customer customer, int agency, int number, BigDecimal limitValue) {
        super(customer, agency, number);
        this.limitValue = limitValue;
    }

    @Override
    public void debitMonthlyFee(BigDecimal fee) {
        withdraw(new BigDecimal(String.valueOf(fee)));
    }

    @Override
    public BigDecimal getAvaiableBalance() {
        return getBalance().add(getLimitValue());
    }

    public BigDecimal getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(BigDecimal limitValue) {
        this.limitValue = limitValue;
    }
}

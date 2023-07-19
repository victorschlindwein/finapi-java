package com.br.victorschlindwein.finapi.models;

public class SpecialAccount extends Account {
    private double limitValue;
    public SpecialAccount(Customer customer, int agency, int number, double limitValue) {
        super(customer, agency, number);
        this.limitValue = limitValue;
    }

    @Override
    public void debitMonthlyFee(double fee) {
        withdraw(fee);
    }

    @Override
    public double getAvaiableBalance() {
        return getBalance() + getLimitValue();
    }

    public double getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(double limitValue) {
        this.limitValue = limitValue;
    }
}

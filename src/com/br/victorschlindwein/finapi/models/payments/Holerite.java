package com.br.victorschlindwein.finapi.models.payments;

import com.br.victorschlindwein.finapi.models.Customer;

import java.math.BigDecimal;

public class Holerite implements PayableDocument {
    private Customer funcionaro;
    private BigDecimal hourValue;
    private BigDecimal hourQty;
    private boolean isPaid;

    public Holerite(Customer funcionaro, BigDecimal hourValue, BigDecimal hourQty) {
        this.funcionaro = funcionaro;
        this.hourValue = hourValue;
        this.hourQty = hourQty;
    }

    @Override
    public BigDecimal getTotalValue() {
        return hourValue.multiply(new BigDecimal(String.valueOf(hourQty)));
    }

    @Override
    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void payDocument() {
        isPaid = true;
    }
}

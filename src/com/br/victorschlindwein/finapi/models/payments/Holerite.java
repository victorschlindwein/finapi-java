package com.br.victorschlindwein.finapi.models.payments;

import com.br.victorschlindwein.finapi.models.Customer;

public class Holerite implements PayableDocument {
    private Customer funcionaro;
    private double hourValue;
    private int hourQty;
    private boolean isPaid;

    public Holerite(Customer funcionaro, double hourValue, int hourQty) {
        this.funcionaro = funcionaro;
        this.hourValue = hourValue;
        this.hourQty = hourQty;
    }

    @Override
    public double getTotalValue() {
        return hourValue * hourQty;
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

package com.br.victorschlindwein.finapi.models.payments;

import com.br.victorschlindwein.finapi.models.Customer;

public class Boleto implements PayableDocument, ReversibleDocument {

    private Customer beneficiario;
    private double value;
    private boolean isPaid;

    @Override
    public double getTotalValue() {
        return value;
    }

    public Boleto(Customer beneficiario, double value) {
        this.beneficiario = beneficiario;
        this.value = value;
    }

    @Override
    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void reversePayment() {
        isPaid = false;
    }

    @Override
    public void payDocument() {
        isPaid = true;
    }
}

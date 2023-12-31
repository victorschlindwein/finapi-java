package com.br.victorschlindwein.finapi.models.payments;

import com.br.victorschlindwein.finapi.models.Customer;

import java.math.BigDecimal;

public class Boleto implements PayableDocument, ReversibleDocument {

    private Customer beneficiario;
    private BigDecimal value;
    private boolean isPaid;

    @Override
    public BigDecimal getTotalValue() {
        return value;
    }

    public Boleto(Customer beneficiario, BigDecimal value) {
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

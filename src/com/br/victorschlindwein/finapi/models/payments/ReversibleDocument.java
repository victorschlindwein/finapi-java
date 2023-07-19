package com.br.victorschlindwein.finapi.models.payments;

public interface ReversibleDocument extends PayableDocument{
    void reversePayment();
}

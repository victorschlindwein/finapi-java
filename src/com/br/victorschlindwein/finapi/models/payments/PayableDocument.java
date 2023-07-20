package com.br.victorschlindwein.finapi.models.payments;

import java.math.BigDecimal;

public interface PayableDocument {
    BigDecimal getTotalValue();
    boolean isPaid();
    void payDocument();
    default void printRecipt(){
        System.out.println("RECIBO:");
        System.out.println("Valor total:" + getTotalValue());
        System.out.println("Pago:" + isPaid());
        System.out.println("--------------------------------");
    }
}

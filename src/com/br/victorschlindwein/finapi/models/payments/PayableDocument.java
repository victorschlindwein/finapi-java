package com.br.victorschlindwein.finapi.models.payments;

public interface PayableDocument {
    double getTotalValue();
    boolean isPaid();
    void payDocument();
    default void printRecipt(){
        System.out.println("RECIBO:");
        System.out.println("Valor total:" + getTotalValue());
        System.out.println("Pago:" + isPaid());
        System.out.println("--------------------------------");
    }
}

package com.br.victorschlindwein.finapi.models.atm;

import com.br.victorschlindwein.finapi.models.Account;
import com.br.victorschlindwein.finapi.models.payments.PayableDocument;
import com.br.victorschlindwein.finapi.models.payments.ReversibleDocument;

public class CaixaEletronico {

    public void printBalance(Account account){
        System.out.println("--------------------------------");
        System.out.println("Conta: " + account.getAgency());
        System.out.println("Titular: " + account.getCustomer().getName());
        System.out.println("Saldo: " + account.getBalance());
        System.out.println("Saldo disponível: " + account.getAvaiableBalance());
        System.out.println("--------------------------------");
    }

    public void pay(PayableDocument document, Account account){
        if (document.isPaid()){
            throw new IllegalStateException("Esse documento já está pago");
        }
        account.withdraw(document.getTotalValue());
        document.payDocument();
    }

    public void reversePayment(ReversibleDocument document, Account account){
        if (!document.isPaid()) {
            throw new IllegalStateException("Nao se poe estornar um documento que não foi pago");
        }
        account.deposit(document.getTotalValue());
        document.reversePayment();
    }
}

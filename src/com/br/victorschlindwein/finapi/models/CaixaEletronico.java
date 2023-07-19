package com.br.victorschlindwein.finapi.models;

public class CaixaEletronico {

    public void printBalance(Account account){
        System.out.println("Conta: " + account.getAgency());
        System.out.println("Titular: " + account.getCustomer().getName());
        System.out.println("Saldo: " + account.getBalance());
        System.out.println("Saldo disponível: " + account.getAvaiableBalance());
    }
}

package com.br.victorschlindwein.finapi.app;

import com.br.victorschlindwein.finapi.models.Account;
import com.br.victorschlindwein.finapi.models.Customer;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Vitor Luiz", "98392");
        Account myAccount = new Account(customer, 101, 123456);

        System.out.println("Suas infos:");
        System.out.println("Nome: " + myAccount.getCustomer().getName());
        System.out.println("Documento: " + myAccount.getCustomer().getDocument());
        System.out.println("Agência: " + myAccount.getAgency());
        System.out.println("Número: " + myAccount.getNumber());
        System.out.println("Saldo: " + myAccount.getBalance());

        myAccount.deposit(7000);
        System.out.println("Saldo após depósito: " + myAccount.getBalance());

        myAccount.withdraw(3000, 5);
        System.out.println("Saldo após saque com taxa: " + myAccount.getBalance());

        Customer customer2 = new Customer("Luiz Vitor Rova", "156465");
        Account myAccount2 = new Account(customer2, 123, 4894);
        myAccount2.deposit(5000);

        System.out.println("Suas infos 2:");
        System.out.println("Nome: " + myAccount2.getCustomer().getName());
        System.out.println("Documento: " + myAccount2.getCustomer().getDocument());
        System.out.println("Agência: " + myAccount2.getAgency());
        System.out.println("Número: " + myAccount2.getNumber());
        System.out.println("Saldo: " + myAccount2.getBalance());

        myAccount2.withdraw(3000);
        System.out.println("Novo saldo após saque sem taxa: " + myAccount2.getBalance());

        customer2.setName("Vitor Luiz");
        System.out.println("Seu nome foi alterado para " + customer2.getName());
    }
}

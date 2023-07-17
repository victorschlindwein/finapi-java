package com.br.victorschlindwein.finapi.app;

import com.br.victorschlindwein.finapi.models.Account;
import com.br.victorschlindwein.finapi.models.Customer;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Vitor Luiz");
        customer.setDocument("98392");

        Account myAccount = new Account(customer, 101, 123456);

        System.out.println("Suas infos:");
        System.out.println("Nome: " + myAccount.getCustomer().getName());
        System.out.println("Documento: " + myAccount.getCustomer().getDocument());
        System.out.println("Agência: " + myAccount.getAgency());
        System.out.println("Número: " + myAccount.getNumber());
        System.out.println("Saldo: " + myAccount.getBalance());

        myAccount.deposit(7000);
        System.out.println("Novo saldo: " + myAccount.getBalance());

        myAccount.withdraw(3000, 25.50);
        System.out.println("Novo novo saldo " + myAccount.getBalance());

        Customer customer2 = new Customer();
        customer2.setName("Vitor Luiz Rovalindo");
        customer2.setDocument("123456");

        Account myAccount2 = new Account(customer2, 123, 4894);
        myAccount2.setCustomer(customer2);
        myAccount2.getCustomer().setDocument("16816");

        myAccount2.deposit(5000);

        System.out.println("Suas infos 2:");
        System.out.println("Nome: " + myAccount2.getCustomer().getName());
        System.out.println("Documento: " + myAccount2.getCustomer().getDocument());
        System.out.println("Agência: " + myAccount2.getAgency());
        System.out.println("Número: " + myAccount2.getNumber());
        System.out.println("Saldo: " + myAccount2.getBalance());



        myAccount2.withdraw(3000);
        System.out.println("Novo novo saldo " + myAccount2.getBalance());
    }
}
package com.br.victorschlindwein.finapi.app;

import com.br.victorschlindwein.finapi.models.Account;
import com.br.victorschlindwein.finapi.models.Customer;
import com.br.victorschlindwein.finapi.models.InvestmentAccount;
import com.br.victorschlindwein.finapi.models.SpecialAccount;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Conta de investimento", "98392");
        InvestmentAccount myAccount = new InvestmentAccount(customer, 101, 123456);

        System.out.println("Suas infos:");
        System.out.println("Nome: " + myAccount.getCustomer().getName());
        System.out.println("Documento: " + myAccount.getCustomer().getDocument());
        System.out.println("Agência: " + myAccount.getAgency());
        System.out.println("Número: " + myAccount.getNumber());
        System.out.println("Saldo: " + myAccount.getBalance());

        double valorDepositado = 15_000;
        myAccount.deposit(valorDepositado);
        myAccount.addInterest(10);
        double balance = myAccount.getBalance();

        System.out.println("Valor atual em conta: " + balance);
        System.out.println("--------------------------------");

        Customer customer2 = new Customer("Conta especial", "98392");
        SpecialAccount myAccount2 = new SpecialAccount(customer2, 101, 123456, 3000);

        System.out.println("Minhas infos:");
        System.out.println("Nome: " + myAccount.getCustomer().getName());
        System.out.println("Documento: " + myAccount.getCustomer().getDocument());
        System.out.println("Agência: " + myAccount.getAgency());
        System.out.println("Número: " + myAccount.getNumber());
        System.out.println("Saldo: " + myAccount.getBalance());

        System.out.println("--------------------------------");

        myAccount2.deposit(valorDepositado);
        System.out.println("Saldo total " + myAccount2.getBalance());
        System.out.println("Valor cheque especial " + myAccount2.getLimitValue());
        double valorSacado = 18_000;
        myAccount2.withdraw(valorSacado);
        System.out.println("Novo valor disponivel após saque de 18k é: " + myAccount2.getBalance());
    }
}

package com.br.victorschlindwein.finapi.app;

import com.br.victorschlindwein.finapi.models.*;
import com.br.victorschlindwein.finapi.models.atm.CaixaEletronico;
import com.br.victorschlindwein.finapi.models.payments.Boleto;
import com.br.victorschlindwein.finapi.models.payments.Holerite;
import com.br.victorschlindwein.finapi.models.payments.PayableDocument;
import com.br.victorschlindwein.finapi.models.payments.ReversibleDocument;

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
        System.out.println("Nome: " + myAccount2.getCustomer().getName());
        System.out.println("Documento: " + myAccount2.getCustomer().getDocument());
        System.out.println("Agência: " + myAccount2.getAgency());
        System.out.println("Número: " + myAccount2.getNumber());
        System.out.println("Saldo: " + myAccount2.getBalance());

        CaixaEletronico caixaEletronico = new CaixaEletronico();
        myAccount2.deposit(10_000);
        caixaEletronico.printBalance(myAccount2);

        caixaEletronico.printBalance(myAccount2);

        Holerite holeriteBacana = new Holerite(myAccount.getCustomer(), 50, 60);
        caixaEletronico.pay(holeriteBacana, myAccount2);

        Boleto boletoSuave = new Boleto(customer2, 2000);
        caixaEletronico.pay(boletoSuave, myAccount2);
        System.out.println("Boleto pago: " + boletoSuave.isPaid());
        caixaEletronico.printBalance(myAccount2);

        System.out.println("Revertendo pagamento:");

        caixaEletronico.reversePayment(boletoSuave, myAccount2);
        System.out.println("Valor revertido foi de: " + boletoSuave.getTotalValue());
        caixaEletronico.printBalance(myAccount2);

        boletoSuave.payDocument();
        boletoSuave.printRecipt();

    }
}

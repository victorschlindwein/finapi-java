package com.br.victorschlindwein.finapi.app;

import com.br.victorschlindwein.finapi.models.*;
import com.br.victorschlindwein.finapi.models.atm.CaixaEletronico;
import com.br.victorschlindwein.finapi.models.exceptions.InsufficientFundsException;
import com.br.victorschlindwein.finapi.models.payments.Boleto;
import com.br.victorschlindwein.finapi.models.payments.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Customer specialCustomer = new Customer("Conta especial", "98392");
        SpecialAccount specialAccount = new SpecialAccount(specialCustomer, 101, 123456, new BigDecimal("3000"));
        specialCustomer.setRendimentoAnual(new BigDecimal("15000"));
        specialCustomer.setCustomerType(CustomerType.JURIDICA);
        System.out.println(specialCustomer.getCustomerType());
        specialCustomer.setLastModifiedDate(LocalDateTime.parse("2023-07-20T13:00:02"));
        System.out.println(specialCustomer.getLastModifiedDate());

        try {
            CaixaEletronico caixaEletronico = new CaixaEletronico();
            specialAccount.deposit(new BigDecimal("10000"));
            caixaEletronico.printBalance(specialAccount);

            Holerite holeriteBacana = new Holerite(specialAccount.getCustomer(), new BigDecimal("50"), new BigDecimal("60"));
            caixaEletronico.pay(holeriteBacana, specialAccount);
            System.out.println("Saldo após pagamento do holerite no valor de: " + (50 * 60));
            caixaEletronico.printBalance(specialAccount);

            Boleto boletoSuave = new Boleto(specialCustomer, new BigDecimal("20000"));
            caixaEletronico.pay(boletoSuave, specialAccount);
            System.out.println("Boleto pago: " + boletoSuave.isPaid());
            caixaEletronico.printBalance(specialAccount);

            System.out.println("Revertendo pagamento:");

            caixaEletronico.reversePayment(boletoSuave, specialAccount);
            System.out.println("Valor revertido foi de: " + boletoSuave.getTotalValue());
            caixaEletronico.printBalance(specialAccount);

            boletoSuave.payDocument();
            boletoSuave.printRecipt();
        } catch (InsufficientFundsException e){
            System.out.println("Mensagem da exceção: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Excecção não catalogada: " + e.getMessage());
        }
    }
}

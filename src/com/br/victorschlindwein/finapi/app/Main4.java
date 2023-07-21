package com.br.victorschlindwein.finapi.app;

import com.br.victorschlindwein.finapi.models.Account;
import com.br.victorschlindwein.finapi.models.Customer;
import com.br.victorschlindwein.finapi.models.Banco;

import java.math.BigDecimal;
import java.util.List;

public class Main4 {

    public static void main(String[] args) {
        Banco banco = new Banco();

        List<Customer> customer = banco.getAccounts().stream()
                .map(Account::getCustomer)
                .distinct()
                .toList();
//                .collect(Collectors.toList());
        System.out.println(customer);

        BigDecimal saldoTotal = banco.getAccounts().stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(saldoTotal);

        banco.getAccounts().stream()
                .filter(conta -> conta.getBalance().compareTo(new BigDecimal("50")) > 0)
                .filter(conta -> conta.getNumber() > 200)
                .map(Account::getCustomer)
                .distinct()
                .forEach(System.out::println);

//        banco.getContas().stream()
//            .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
//            .filter(conta -> conta.getNumero() > 200)
//            .sorted(Comparator.comparingInt(Conta::getNumero))
//            .forEach(conta -> {
//                System.out.println(conta.getAgencia() + "/" + conta.getNumero()
//                    + " = " + conta.getSaldo());
//            });
    }

}
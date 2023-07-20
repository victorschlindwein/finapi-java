package com.br.victorschlindwein.finapi.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Account> contas = new ArrayList<>();

    public Banco() {
        Customer pessoa1 = new Customer("João da Silva", "12312312311");
        Customer pessoa2 = new Customer("Maria das Couves", "12312312311");

        Account conta1 = new InvestmentAccount(pessoa1, 222, 999);
        Account conta2 = new InvestmentAccount(pessoa1, 123, 888);
        Account conta3 = new InvestmentAccount(pessoa2, 123, 567);
        Account conta4 = new SpecialAccount(pessoa1, 123, 188, new BigDecimal("10000"));
        Account conta5 = new SpecialAccount(pessoa2, 123, 222, new BigDecimal("2000"));

        conta1.deposit(new BigDecimal("120"));
        conta2.deposit(new BigDecimal("150"));
        conta3.deposit(new BigDecimal("500"));
        conta5.deposit(new BigDecimal("12000"));

        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);
        contas.add(conta4);
        contas.add(conta5);
    }

    public List<Account> getContas() {
        return contas;
    }
    
}
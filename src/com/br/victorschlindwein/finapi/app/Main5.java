package com.br.victorschlindwein.finapi.app;


import com.br.victorschlindwein.finapi.models.Account;
import com.br.victorschlindwein.finapi.models.Banco;

import java.math.BigDecimal;

public class Main5 {

    public static void main(String[] args) {
        Banco banco = new Banco();

//        Optional<Conta> contaOptional = banco.buscar(123, 222);

//        banco.buscar(123, 222)
//                .ifPresent(conta -> System.out.println(conta.getSaldo()));

//        if (contaOptional.isPresent()) {
//            Conta contaEncontrada = contaOptional.get();
//            System.out.println(contaEncontrada.getSaldo());
//        }

//        Conta contaEncontrada = banco.buscar(123, 333)
//                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
//
//        System.out.println(contaEncontrada.getSaldo());

        BigDecimal saldo = banco.getAccountByAgencyAndNumber(222, 333)
                .map(Account::getBalance)
                .orElse(BigDecimal.ZERO);

        System.out.println(saldo);
    }

}
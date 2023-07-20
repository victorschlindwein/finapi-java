package com.br.victorschlindwein.finapi.app;

import com.br.victorschlindwein.finapi.models.Account;
import com.br.victorschlindwein.finapi.models.Banco;

import java.util.Comparator;

public class Main3 {

    public static <Conta> void main(String[] args) {
        Banco banco = new Banco();

//        ToIntFunction<Conta> function = (Conta conta) -> {
//            return conta.getNumero();
//        };

//        banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction()));
//        banco.getContas().sort(Comparator.comparingInt(
//                conta -> conta.getNumero()));

        banco.getContas().sort(Comparator.comparingInt(Account::getNumber));

        for (Account conta : banco.getContas()) {
            System.out.println(conta.getAgency() + "/" + conta.getNumber());
        }
    }

}
package com.br.victorschlindwein.finapi.app;

import com.br.victorschlindwein.finapi.models.Account;

import java.util.function.ToIntFunction;

public class NumeroContaFunction implements ToIntFunction<Account> {

    @Override
    public int applyAsInt(Account conta) {
        return conta.getNumber();
    }
}

package com.br.victorschlindwein.finapi.app;

import java.math.BigDecimal;

public class MainTestBigDecimalVsDouble {

    public static void main(String[] args) {
        BigDecimal x = new BigDecimal("1.0");
        x = x.subtract(new BigDecimal("0.10"));
        x = x.subtract(new BigDecimal("0.20"));
        x = x.subtract(new BigDecimal("0.30"));
        System.out.println(x);

//        double x = 1.0;
//        x = x - 0.10;
//        x = x - 0.20;
//        x = x - 0.30;
//        System.out.println(x);
    }

}

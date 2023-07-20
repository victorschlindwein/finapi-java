package com.br.victorschlindwein.finapi.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Customer {
    private String name;
    private final String document;
    private BigDecimal rendimentoAnual;
    private CustomerType customerType = CustomerType.FISICA;
    private LocalDateTime lastModifiedDate = LocalDateTime.now();

    public Customer(String name, String document){
        this.name = name;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public BigDecimal getRendimentoAnual() {
        return rendimentoAnual;
    }

    public void setRendimentoAnual(BigDecimal rendimentoAnual) {
        this.rendimentoAnual = rendimentoAnual;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}

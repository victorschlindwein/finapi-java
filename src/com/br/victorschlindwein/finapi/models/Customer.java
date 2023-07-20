package com.br.victorschlindwein.finapi.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Customer {
    private String name;
    private String document;
    private BigDecimal rendimentoAnual;
    private CustomerType customerType = CustomerType.FISICA;
    private LocalDateTime lastModifiedDate = LocalDateTime.now();

    public Customer(String name, String document){
        this.name = name;
        this.document = document;
    }

    public Customer(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", customerType=" + customerType +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return Objects.equals(document, customer.document);
    }
    @Override
    public int hashCode() {
        return Objects.hash(document);
    }
}

package com.br.victorschlindwein.finapi.models;

public class Customer {
    private String name;
    private final String document;

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
}

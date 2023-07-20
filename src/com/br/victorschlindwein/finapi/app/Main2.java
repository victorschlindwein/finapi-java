package com.br.victorschlindwein.finapi.app;

import com.br.victorschlindwein.finapi.models.Customer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Rovaris", "156161");
        Customer customer2 = new Customer("Jardanelson", "219382");

        Set<Customer> customers = new HashSet<>();
        customers.add(customer1);
        customers.add(customer2);

//        System.out.println(customers);

//        for(int i = 0; i < customers.size(); i++){
//            System.out.println(customers.get(i).getName());
//        }

        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }

//        boolean exists = customers.contains(customer1);
//        System.out.println(exists);
    }
}

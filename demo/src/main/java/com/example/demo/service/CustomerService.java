package com.example.demo.service;

import com.example.demo.model.Customer;

public interface CustomerService {
    Customer findByName(String name);
    Customer createCustomer(Customer customer);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(String name);
}

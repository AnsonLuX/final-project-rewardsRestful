package com.example.demo.dao;

import com.example.demo.entity.CustomerInfoEntity;

import java.util.List;

public interface CustomerDAO {
    List<CustomerInfoEntity> findAll();
    CustomerInfoEntity findByName(String name);
    CustomerInfoEntity saveCustomer(CustomerInfoEntity customerInfoEntity);
    void deleteCustomer(String name);
}

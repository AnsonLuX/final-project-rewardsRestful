package com.example.demo.service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.CustomerInfoEntity;
import com.example.demo.model.Customer;
import com.example.demo.util.EntityVoConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

    private CustomerDAO customerDAO;
    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    @Override
    public Customer findByName(String name) {
        CustomerInfoEntity customerInfoEntity = customerDAO.findByName(name);
        return EntityVoConverter.convertEntityToVo(customerInfoEntity);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return null;
    }
    @Transactional
    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerInfoEntity customerInfoEntity = customerDAO.saveCustomer(
                EntityVoConverter.convertVoToEntity(customer));
        return EntityVoConverter.convertEntityToVo(customerInfoEntity);
    }
    @Transactional
    @Override
    public void deleteCustomer(String name) {
        customerDAO.deleteCustomer(name);
    }
}

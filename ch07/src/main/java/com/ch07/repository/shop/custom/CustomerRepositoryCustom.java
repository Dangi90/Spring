package com.ch07.repository.shop.custom;

import com.ch07.entity.shop.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    public List<Customer> selectCustomers();
    public Customer selectCustomerById(String custId);

    public List<Customer> searchCustomer(String nameCondition, int ageCondition);
    public List<Customer> searchKeyword(String keyword);
}

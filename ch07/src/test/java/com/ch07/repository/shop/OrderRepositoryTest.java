package com.ch07.repository.shop;

import com.ch07.entity.shop.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void selectCustomers() {
        List<Customer> customers = customerRepository.selectCustomers();
        System.out.println(customers);
    }
    @Test
    public void selectCustomer() {
        Customer customer = customerRepository.selectCustomerById("a101");
        System.out.println(customer);

    }
    @Test
    public void searchCustomer() {

        List<Customer> customers1 = customerRepository.searchCustomer("김유신",23);
        List<Customer> customers2 = customerRepository.searchCustomer("김유신",0);
        List<Customer> customers3 = customerRepository.searchCustomer(null,23);
        List<Customer> customers4 = customerRepository.searchCustomer(null,0);

        System.out.println(customers1);
        System.out.println(customers2);
        System.out.println(customers3);
        System.out.println(customers4);
    }

    @Test
    public void searchKeyword() {

        List<Customer> customers1 =  customerRepository.searchKeyword("춘추");
        List<Customer> customers2 =  customerRepository.searchKeyword("경주");

        System.out.println(customers1);
        System.out.println(customers2);
    }
}
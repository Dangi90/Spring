package com.ch07.repository.shop.custom;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;

import java.util.List;

public interface OrderRepositoryCustom {
    List<Order> selectOrders();

    Order selectOrdersById(String orderId);

    Order selectOrdersById(int orderId);

    List<Order> searchCustomer(int IdCondition, int priceCondition);

    List<Customer> searchKeyword(String keyword);
}

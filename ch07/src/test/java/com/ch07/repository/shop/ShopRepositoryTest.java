package com.ch07.repository.shop;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.OrderItem;
import com.ch07.entity.shop.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ShopRepositoryTest {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private OrderItemRepository orderItemRepository;
    @Autowired private ProductRepository productRepository;

    // 테스트1 - 고객 등록
    @Test
    public void insertCustomer(){
        Customer customer = Customer.builder()
                .custId("a102")
                .name("김춘추")
                .age(21)
                .hp("010-1234-1002")
                .addr("경주")
                .build();

        customerRepository.save(customer);
    }

    // 테스트2 - 상품 등록
    @Test
    public void insertProduct(){
        Product product1 = Product.builder()
                .productName("새우깡")
                .price(1000)
                .stock(100)
                .build();

        Product product2 = Product.builder()
                .productName("포카칩")
                .price(1500)
                .stock(300)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
    }

    // 테스트3 - 주문 등록
    @Test
    public void insertOrder(){

        Customer customer = Customer.builder()
                .custId("a101")
                .build();

        Product product1 = Product.builder().productId(1).build();
        Product product2 = Product.builder().productId(2).build();

        Order order = Order.builder()
                .customer(customer)
                .orderPrice(3000)
                .orderStatus(1)
                .build();

        orderRepository.save(order);
    }

    // 테스트4 - 주문 아이템 등록
    @Test
    public void insertOrderItem(){

        Order order = Order.builder().orderId(1).build();
        Product product1 = Product.builder().productId(1).build();
        Product product2 = Product.builder().productId(2).build();

        OrderItem item1 = OrderItem.builder()
                .order(order)
                .product(product1)
                .count(2)
                .build();

        OrderItem item2 = OrderItem.builder()
                .order(order)
                .product(product2)
                .count(3)
                .build();

        orderItemRepository.save(item1);
        orderItemRepository.save(item2);
    }

    // 테스트5 - 주문 조회
    @Transactional
    @Test
    public void selectOrder(){
        List<Order> orders = orderRepository.findAll();
        System.out.println(orders);
    }

}
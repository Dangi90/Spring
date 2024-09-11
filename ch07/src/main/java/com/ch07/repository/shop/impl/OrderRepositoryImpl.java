package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.QOrder;
import com.ch07.repository.shop.custom.OrderRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

// CustomerRspository 확장 인터페이스 구현 클래스
@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private QOrder qorder = QOrder.order;


    @Override
    public List<Order> selectOrders() {
        return queryFactory
                .select(qorder)
                .from(qorder)
                .fetch();
    }

    @Override
    public Order selectOrdersById(String orderId) {
        return null;
    }

    @Override
    public Order selectOrdersById(int orderId) {
        Order order = queryFactory
                .selectFrom(qorder)
                .where(qorder.orderId.eq(orderId))
                .fetchOne();
        return order;
    }

    @Override
    public List<Order> searchCustomer(int IdCondition, int priceCondition) {

        BooleanBuilder builder = new BooleanBuilder();
        
        if(qorder.orderId != null) {
            builder.and(qorder.orderId.eq(IdCondition));
        }
        
        if(priceCondition > 0) {
            builder.and(qorder.orderPrice.goe(priceCondition)); // goe : Greater than Or Equal (크거나 같다)
            
            return queryFactory
                    .selectFrom(qorder)
                    .where(builder) //조건에 따라 동적 쿼리 실행
                    .fetch();
        }
        
        return List.of();
    }

    @Override
    public List<Customer> searchKeyword(String keyword) {
        return List.of();
    }

}

package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.QCustomer;
import com.ch07.repository.shop.CustomerRepository;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
// CustomerRspository 확장 인터페이스 구현 클래스
@RequiredArgsConstructor
@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private QCustomer qCustomer = QCustomer.customer;

    @Override
    public List<Customer> selectCustomers() {
        // select * from customer
        return queryFactory
                .select(qCustomer)
                .from(qCustomer)
                .fetch();
    }

    @Override
    public Customer selectCustomerById(String custId) {
        return queryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.custId.eq(custId))
                .fetchOne();
    }

    @Override
    public List<Customer> searchCustomer(String nameCondition, int ageCondition) {

        BooleanBuilder builder = new BooleanBuilder();
        
        if(nameCondition != null) {
            builder.and(qCustomer.name.eq(nameCondition));
        }
        
        if(ageCondition > 0) {
            builder.and(qCustomer.age.goe(ageCondition)); // goe : Greater than Or Equal (크거나 같다)
            
            return queryFactory
                    .selectFrom(qCustomer)
                    .where(builder) //조건에 따라 동적 쿼리 실행
                    .fetch();
        }
        
        return List.of();
    }

    @Override
    public List<Customer> searchKeyword(String keyword) {

        BooleanExpression express = qCustomer
                .name.containsIgnoreCase(keyword)
                .or(qCustomer.name.likeIgnoreCase(keyword));

        return queryFactory
                .selectFrom(qCustomer)
                .where(express)
                .fetch();
    }
}

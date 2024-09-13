package com.ch09.repository;

import com.ch09.entity.User1;
import com.ch09.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User2Repository extends JpaRepository<User2, String> {
}

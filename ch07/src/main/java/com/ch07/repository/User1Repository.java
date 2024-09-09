package com.ch07.repository;

import com.ch07.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<T, ID> 사용하는 엔티티 타입과 해당 엔티티의 @ID 컬럼 속성 타입 선언
@Repository
public interface User1Repository extends JpaRepository<User1, String> {

}

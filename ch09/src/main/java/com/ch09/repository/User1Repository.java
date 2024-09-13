package com.ch09.repository;

import com.ch09.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository<T, ID> 사용하는 엔티티 타입과 해당 엔티티의 @ID 컬럼 속성 타입 선언
@Repository
public interface User1Repository extends JpaRepository<User1, String> {

    // 사용자 정의 쿼리 메서드
    public User1 findUser1ByUid(String username);
    public List<User1> findUser1ByName(String username);
    public List<User1> findUser1ByNameNot(String username);

    public User1 findUser1ByUidAndName(String uid, String name);
    public List<User1> findUser1ByUidOrName(String uid, String name);

    public List<User1> findUser1ByAgeGreaterThan(int age);
    public List<User1> findUser1ByAgeGreaterThanEqual(int age);
    public List<User1> findUser1ByAgeLessThan(int age);
    public List<User1> findUser1ByAgeLessThanEqual(int age);
    public List<User1> findUser1ByAgeBetween(int low, int high);

    // JPQL : JPA Native SQL
    @Query("select u1 from User1 as u1 where u1.age < 30")
    public List<User1> selelctUser1UnderAge30();

    @Query("select u1 from User1 as u1 where u1.name = ?1")
    public List<User1> selelctUser1WhereName(String name);

    @Query("select u1 from User1 as u1 where u1.name = :name")
    public List<User1> selectUser1WhereNameParam(@Param("name")String name);


}

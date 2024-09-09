package com.ch07.entity;

import com.ch07.dto.User1DTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import javax.naming.Name;

//entity 는 보안상 setter 안씀
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                     //엔티티 객체 정의
@Table(name = "user1")      //매핑 테이블 설정
public class User1 {
    @Id // PK 컬럼을 @Id 태그로 설정(엔티티에 반드시 한개 이상)
    private String uid;
    @Column(name = "name")//컬럼명은 생략가능
    private String name;
    @Column(name ="birth")
    private String birth;
    @Column(name = "hp")
    private String hp;
    @Column(name = "age")
    private int age;

    //DTO 변환 메서드
    public User1DTO toDTO(){
        return User1DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }
}
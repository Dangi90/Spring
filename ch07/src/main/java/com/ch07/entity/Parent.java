package com.ch07.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                     //엔티티 객체 정의
@Table(name = "parent")
public class Parent {

    @Id // PK 컬럼을 @Id 태그로 설정(엔티티에 반드시 한개 이상)
    private String pid;
    private String name;
    private String birth;
    private String addr;
}

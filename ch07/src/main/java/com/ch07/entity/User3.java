package com.ch07.entity;

import com.ch07.dto.User3DTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

//entity 는 보안상 setter 안씀
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                     //엔티티 객체 정의
@Table(name = "user3")      //매핑 테이블 설정
public class User3 {
    @Id // PK 컬럼을 @Id 태그로 설정(엔티티에 반드시 한개 이상)
    private String uid;
    private String name;
    private String birth;
    private String hp;
    private String addr;

    //DTO 변환 메서드
    public User3DTO toDTO(){
        return User3DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .addr(addr)
                .build();
    }
}

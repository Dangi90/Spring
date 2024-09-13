package com.ch09.dto;

import com.ch09.entity.User1;
import com.ch09.entity.User2;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class User2DTO {
    private String uid;
    private String name;
    private String birth;
    private String hp;
    private int age;

    //엔티티 변환 메서드
    public User2 toEntity(){
        // Builder 방식 생성
        return User2.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }
}

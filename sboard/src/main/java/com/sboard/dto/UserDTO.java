package com.sboard.dto;

import com.sboard.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String uid;
    private String pass;
    private String name;
    private String nick;
    private String email;
    private String hp;
    private String role;
    private String zip;
    private String addr1;
    private String addr2;
    private String regip;
    private String regDate;
    private String leaveDate;

    public User toEntity() {
        return  User.builder()
                .uid(uid)
                .pass(pass)
                .name(name)
                .email(email)
                .hp(hp)
                .role(role)
                .zip(zip)
                .addr1(addr1)
                .addr2(addr2)
                .regip(regip)
                .regDate(regDate != null ? regDate.toString() : "") // null 체크
                .leaveDate(leaveDate != null ? leaveDate.toString() : "") // null 체크
                .build();
    }
}
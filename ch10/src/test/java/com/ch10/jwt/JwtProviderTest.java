package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {

        User user = User.builder()
                .uid("A101")
                .name("김유신")
                .birth("1990-09-09")
                .role("ADMIN")
                .build();

        String jwt = jwtProvider.createToken(user,1);
        System.out.println(jwt);
    }

    @Test
    void getClaims() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3b28yNDQ2NUBnbWFpbC5jb20iLCJpYXQiOjE3MjYxMjI5MTcsImV4cCI6MTcyNjIwOTMxNywidXNlcm5hbWUiOiJBMTAxIiwicm9sZSI6IkFETUlOIn0.dzn3vtun70wKmcsjtQAni_v6CV3rikNGIjy8RP01dLg";

        Claims claims = jwtProvider.getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        System.out.println(username + " " + role);
    }

    @Test
    void getAuthentication() {
    }

    @Test
    void validateToken() {

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3b28yNDQ2NUBnbWFpbC5jb20iLCJpYXQiOjE3MjYxMjI5MTcsImV4cCI6MTcyNjIwOTMxNywidXNlcm5hbWUiOiJBMTAxIiwicm9sZSI6IkFETUlOIn0.dzn3vtun70wKmcsjtQAni_v6CV3rikNGIjy8RP01dLg";

        try {
            jwtProvider.validateToken(token);
            System.out.println("토큰이상없음");

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
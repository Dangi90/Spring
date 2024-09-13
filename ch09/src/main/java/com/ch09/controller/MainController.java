package com.ch09.controller;

import com.ch09.dto.User1DTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @GetMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/api/users")
    public List<User1DTO> getUsers() {
        List<User1DTO> users = new ArrayList<>();
        users.add(new User1DTO("user1", "홍길동", "1990-01-01", "010-1234-5678", 33));
        users.add(new User1DTO("user2", "김철수", "1985-05-05", "010-9876-5432", 39));
        return users;
    }
}

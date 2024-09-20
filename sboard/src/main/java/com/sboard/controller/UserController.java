package com.sboard.controller;

import com.sboard.dto.UserDTO;
import com.sboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @Value("${spring.application.version}")
    private String appVersion;

    @GetMapping("/user/login")
    public String login(Model model) {
        model.addAttribute("appVersion", appVersion);
        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register() {
        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(UserDTO userDTO){
        userService.insertUser(userDTO);
        return "redirect:/user/login";
    }

    @GetMapping("/user/terms")
    public String terms() {
        return "/user/terms";
    }
}

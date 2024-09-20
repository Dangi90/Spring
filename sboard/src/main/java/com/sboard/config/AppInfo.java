package com.sboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AppInfo {

    @Value("${spring.application.version}")
    private String appVersion;

    public String login(Model model) {
        model.addAttribute("appVersion", appVersion);
        return "/user/login";
    }
}

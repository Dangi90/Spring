package com.sboard.config;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public AppInfo appInfo() {
        return new AppInfo();
    }
}

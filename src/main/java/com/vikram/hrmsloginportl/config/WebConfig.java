package com.vikram.hrmsloginportl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all endpoints
                .allowedOrigins("http://localhost:3000")  // React frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")  // Allowed HTTP methods
                .allowedHeaders("Authorization", "Content-Type")  // Allow Authorization header
                .allowCredentials(true);  // Allow cookies and authorization headers
    }
}

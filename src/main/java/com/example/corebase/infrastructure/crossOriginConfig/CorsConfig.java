package com.example.corebase.infrastructure.crossOriginConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${domain.client}")
    private String domainClients;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        for (String s : this.domainClients.split(", ")) {
        System.out.println(this.domainClients + " aaaaaa");
            registry.addMapping("/**")
                    .allowedOrigins(this.domainClients.split(", "))
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("Authorization", "Content-Type");
//        }
    }
}

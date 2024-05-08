package com.example.corebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource(value = "classpath:application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
public class CoreBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreBaseApplication.class, args);
    }

}

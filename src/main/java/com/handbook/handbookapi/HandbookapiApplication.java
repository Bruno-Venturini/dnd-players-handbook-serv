package com.handbook.handbookapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class HandbookapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HandbookapiApplication.class, args);
    }
}

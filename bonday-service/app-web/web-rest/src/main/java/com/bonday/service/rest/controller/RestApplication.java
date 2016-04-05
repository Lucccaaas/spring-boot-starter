package com.bonday.service.rest.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * Created by yunge on 16/4/3.
 */
@SpringBootApplication(scanBasePackages = "com.bonday")
@EnableMongoAuditing
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}

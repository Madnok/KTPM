package com.example.usermanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.usermanagementservice")
@ComponentScan(basePackages = { "com.example.usermanagementservice.model", "com.example.usermanagementservice.repository", "com.example.usermanagementservice.service" })
@EntityScan(basePackages = "com.example.usermanagementservice.model")
@EnableJpaRepositories(basePackages = "com.example.usermanagementservice.repository")
public class UserManagementServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserManagementServiceApplication.class, args);
		System.out.println("Hello World!");
    }
}

package com.help.yourself.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.help.yourself.*"})
@EnableJpaRepositories(basePackages = {"com.help.yourself.*"})
@EntityScan(basePackages =  {"com.*"})
public class WebApplication {
    public static void main(String[] args){
        SpringApplication.run(WebApplication.class, args);
    }
}

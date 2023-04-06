package com.blogapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

@SpringBootApplication()
public class BlogAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogAppApplication.class, args);
    }
}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.example, com.common")
public class ApiServiceApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApiServiceApplication.class, args);
	}

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Narendranadh P
 * @since 20-01-2020
 * @version 1.0
 *
 */
@ComponentScan("com.example.controller")
@ComponentScan("com.example.service")
@ComponentScan("com.example.dao")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

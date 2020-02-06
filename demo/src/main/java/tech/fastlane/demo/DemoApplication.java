package tech.fastlane.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Narendranadh P
 * @since 10-01-2020
 * @version 1.0
 *
 */
@ComponentScan("tech.fastlane.controller")
@ComponentScan("tech.fastlane.service")
@ComponentScan("tech.fastlane.dao")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

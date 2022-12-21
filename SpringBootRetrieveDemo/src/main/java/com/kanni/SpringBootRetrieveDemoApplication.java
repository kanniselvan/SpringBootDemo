package com.kanni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class SpringBootRetrieveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRetrieveDemoApplication.class, args);
	}

}

package com.iam.iam_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class IamServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamServerApplication.class, args);
	}
}
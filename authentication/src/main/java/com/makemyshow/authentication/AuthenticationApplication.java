package com.makemyshow.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication

public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AuthenticationApplication.class);
		ConfigurableEnvironment environment = app.run(args).getEnvironment();

		System.out.println("Server is running on port: " + environment.getProperty("server.port"));
	}

}

package com.moviebooking.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		// SpringApplication.run(MovieApplication.class, args);
		SpringApplication app = new SpringApplication(MovieApplication.class);
		ConfigurableEnvironment environment = app.run(args).getEnvironment();

		System.out.println("Server is running on port: " + environment.getProperty("server.port"));
	}

}

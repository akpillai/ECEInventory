package com.virginiatech.ece;
//anusha - anusha@18thJune

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class EceinventoryInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EceinventoryInitializer.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EceinventoryInitializer.class, args);
	}
}

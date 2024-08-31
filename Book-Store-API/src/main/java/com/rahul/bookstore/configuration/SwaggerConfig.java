package com.rahul.bookstore.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI usersMicroserviceOpenAPI() {

		Server localhost = new Server();
		localhost.setUrl("http://hostname:8080");
		localhost.setDescription("");

		Contact contact = new Contact();
		contact.setEmail("rahuladkar2@gmail.com");
		contact.setName("Book Store Api");
		contact.setUrl("https://bookstore.in");

		License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

		Info info = new Info().title("Book Store API").version("1.0").contact(contact)
				.description("A simple Spring Boot REST API for managing books in a BookStore.")
				.termsOfService("https://bookstore/terms").license(mitLicense);

		return new OpenAPI().info(info).servers(Arrays.asList(localhost));
	}

}
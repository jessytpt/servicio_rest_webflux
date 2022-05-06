package com.webfluxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebfluxDemoApplication {

	public static void main(String[] args) {
		// Link de heroku: https://api-webflux-start.herokuapp.com/customers/all
		SpringApplication.run(WebfluxDemoApplication.class, args);
	}

}

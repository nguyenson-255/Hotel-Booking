package com.example.hotel_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class HotelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApiApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "Welcome to the Hotel API!";
	}
}

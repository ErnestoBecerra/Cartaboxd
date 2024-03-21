package com.cartaboxd.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CartaboxdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartaboxdApplication.class, args);
	}

}

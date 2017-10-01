package com.pal.farm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication
public class Farm {

	public static void main(String[] args) {
		SpringApplication.run(Farm.class, args);
	}

}

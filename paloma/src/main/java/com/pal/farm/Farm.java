package com.pal.farm;


import org.dozer.DozerBeanMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication
public class Farm {

	public static void main(String[] args) {
		SpringApplication.run(Farm.class, args);
	}
	
	@Bean
	public DozerBeanMapper mapper() {
		return new DozerBeanMapper();
	}
}

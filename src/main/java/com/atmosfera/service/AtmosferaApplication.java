package com.atmosfera.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = { "com.atmosfera" })
@ConfigurationPropertiesScan("com.atmosfera")
@ComponentScan({ "com.atmosfera" })
public class AtmosferaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmosferaApplication.class, args);
	}

}

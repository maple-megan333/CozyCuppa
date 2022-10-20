package com.maplemegan.cozycuppa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.maplemegan"},exclude = { SecurityAutoConfiguration.class })
public class CozycuppaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CozycuppaApplication.class, args);
		
		
	}

}

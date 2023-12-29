package com.projects.oddsPickr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.projects.oddsPickr")
public class OddsPickrApplication {

	public static void main(String[] args) {
		SpringApplication.run(OddsPickrApplication.class, args);
	}

}

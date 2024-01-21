package com.projects.oddsPickr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
@SpringBootApplication
@ComponentScan("com.projects.oddsPickr")
public class OddsPickrApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(OddsPickrApplication.class, args);
    }
}
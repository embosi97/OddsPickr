package com.projects.oddsPickr.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "OddsPickr API",
                description = "Betting Odds Tracker",
                contact = @Contact(
                        name = "Emil B.",
                        email = "embosi97@gmail.com",
                        url = "https://github.com/embosi97/OddsPickr"
                ),
                version = "1.0"
        ),
        servers = @Server(
                description = "Local Environment",
                url = "http://localhost:8080"
        )
)
public class OpenAPIConfig {

}

package com.projects.oddsPickr.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.web.bind.annotation.GetMapping;

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

    @Operation(
            description = "Get Event(s) by Sport/Event ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found: Invalid Sport, Region, or Event ID"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Unauthorized: Invalid URL or permission"
                    )
            }
    )
    @GetMapping
    public String get() {
        return "Get Mapping";
    }

}

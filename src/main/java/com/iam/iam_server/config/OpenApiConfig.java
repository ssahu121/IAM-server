package com.iam.iam_server.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()

                .info(new Info()
                        .title("Identity and Access Management (IAM) Server API")
                        .description("""
                                REST API documentation for the Identity and Access Management (IAM) Server.
                                
                                Features:
                                • User Registration & Login
                                • JWT Authentication
                                • Role-Based Access Control (RBAC)
                                • Permission Management
                                • Forgot & Reset Password
                                • User Profile Management
                                """)
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Shivam Sahu")
                                .email("sharan26.06.2006@gmail.com"))
                        .license(new License()
                                .name("MIT License")))

                .addServersItem(new Server()
                        .url("http://localhost:8080")
                        .description("Local Development Server"))

                .addSecurityItem(new SecurityRequirement()
                        .addList(SECURITY_SCHEME_NAME))

                .components(new Components()
                        .addSecuritySchemes(
                                SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        ));
    }
}
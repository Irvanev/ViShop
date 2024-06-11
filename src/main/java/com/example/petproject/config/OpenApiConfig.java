package com.example.petproject.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "ViShop API",
                description = "API for website of electronics", version = "1.0.0",
                contact = @Contact(
                        name = "Vitaly Irvanev",
                        email = "irvvanevv@mail.ru"
                )
        )
)
public class OpenApiConfig {
}

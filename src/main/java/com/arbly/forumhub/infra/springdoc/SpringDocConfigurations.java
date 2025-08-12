package com.arbly.forumhub.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                        .info(new Info()
                                .title("Forum Hub API")
                                .version("0.0.1-SNAPSHOT")
                                .summary("Desafio proposto no programa ONE (Oracle Next Education). Uma parceria entre Alura Latam e Oracle. Grupo G8 (2025).")
                                .description("to do...")
                                .contact(new Contact()
                                        .name("Ricardo G")
                                        .url("https://github.com/rrbotlab/challenge-java-forumhub-one-g8"))
                        .license(new License()
                                .name("MIT")));
    }

}

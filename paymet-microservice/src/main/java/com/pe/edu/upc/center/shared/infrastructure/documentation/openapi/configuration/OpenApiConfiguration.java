package com.pe.edu.upc.center.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
  @Bean
  public OpenAPI learningPlatformOpenApi() {
    // General configuration
    var openApi = new OpenAPI();
    openApi
            .info(new Info()
                    .title("Payment microservice API")
                    .description("Payment microservice documentation.")
                    .version("v1.0.0")
                    .license(new License().name("Apache 2.0")
                            .url("https://springdoc.org")))
            .externalDocs(new ExternalDocumentation()
                    .description(" Payment microservice Documentation")
                    .url("https://github.com/upc-is-si729/daos-language-reference"));

    // Add security scheme
    final String securitySchemeName = "bearerAuth";

    openApi.addSecurityItem(new SecurityRequirement()
                    .addList(securitySchemeName))
            .components(new Components()
                    .addSecuritySchemes(securitySchemeName,
                            new SecurityScheme()
                                    .name(securitySchemeName)
                                    .type(SecurityScheme.Type.HTTP)
                                    .scheme("bearer")
                                    .bearerFormat("JWT")));

    return openApi;
  }
}

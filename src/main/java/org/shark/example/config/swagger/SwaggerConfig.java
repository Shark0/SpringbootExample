package org.shark.example.config.swagger;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi multiLanguageExampleApis() {
        return GroupedOpenApi.builder()
                .group("i18n-example-apis")
                .displayName("Multi Language Example Apis")
                .packagesToScan("org.shark.example.controller.i18n")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(info("Multi Language Example APIS", "Multi Language Example APIS")))
                .build();
    }

    @Bean
    GroupedOpenApi mapstructExampleApis() {
        return GroupedOpenApi.builder()
                .group("mapstruct-example-apis")
                .displayName("Map Struct Example Apis")
                .packagesToScan("org.shark.example.controller.mapstruct")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(info("Mapstruct Example APIS", "Mapstruct Example APIS")))
                .build();
    }

    private Info info(String title, String description) {
        return new Info()
                .title(title)
                .version("0.0.1")
                .description(description);
    }

}

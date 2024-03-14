package org.shark.example.config.swagger;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi rabbitMqExampleApis() {
        return GroupedOpenApi.builder()
                .group("rabbit-mq-example-apis")
                .displayName("RabbitMQ Example Apis")
                .packagesToScan("org.shark.example.controller.rabbit")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(info("RabbitMQ Example APIS", "RabbitMQ Example APIS")))
                .build();
    }

    private Info info(String title, String description) {
        return new Info()
                .title(title)
                .version("0.0.1")
                .description(description);
    }

}

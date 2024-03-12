package org.shark.example.config.swagger;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi kafkaExampleApis() {
        return GroupedOpenApi.builder()
                .group("kafka-example-apis")
                .displayName("Kafka Example Apis")
                .packagesToScan("org.shark.example.controller.kafka")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(info("Kafka Example APIS", "Kafka Example APIS")))
                .build();
    }

    private Info info(String title, String description) {
        return new Info()
                .title(title)
                .version("0.0.1")
                .description(description);
    }

}

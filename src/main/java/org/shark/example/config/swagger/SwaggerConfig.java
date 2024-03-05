package org.shark.example.config.swagger;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi redisExampleApis() {
        return GroupedOpenApi.builder()
                .group("redis-example-apis")
                .displayName("Redis Example APIS")
                .packagesToScan("org.shark.example.controller.redis")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(info("Redis Example APIS", "Redis Example APIS")))
                .build();
    }

    @Bean
    GroupedOpenApi multiLanguageExampleApis() {
        return GroupedOpenApi.builder()
                .group("multi-language-example-apis")
                .displayName("Multi Language Example Apis")
                .packagesToScan("org.shark.example.controller.i18n")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(info("Multi Language Example APIS", "Multi Language Example APIS")))
                .build();
    }

    @Bean
    GroupedOpenApi mySqlExampleApis() {
        return GroupedOpenApi.builder()
                .group("mysql-example-apis")
                .displayName("Mysql Example Apis")
                .packagesToScan("org.shark.example.controller.mysql")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(info("Mysql Example APIS", "Mysql Example APIS")))
                .build();
    }

    @Bean
    GroupedOpenApi quartzExampleApis() {
        return GroupedOpenApi.builder()
                .group("quartz-example-apis")
                .displayName("Quartz Example Apis")
                .packagesToScan("org.shark.example.controller.quartz")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(info("Quartz Example APIS", "Quartz Example APIS")))
                .build();
    }

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

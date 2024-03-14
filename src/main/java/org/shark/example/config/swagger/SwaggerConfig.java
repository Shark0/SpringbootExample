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

    private Info info(String title, String description) {
        return new Info()
                .title(title)
                .version("0.0.1")
                .description(description);
    }

}

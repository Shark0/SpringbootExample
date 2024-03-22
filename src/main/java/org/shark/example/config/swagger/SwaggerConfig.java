package org.shark.example.config.swagger;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

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
    GroupedOpenApi jobExampleApis() {
        return GroupedOpenApi.builder()
                .group("job-example-apis")
                .displayName("Job Example Apis")
                .packagesToScan("org.shark.example.controller.quartz")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(info("Job Example APIS", "Job Example APIS")))
                .build();
    }

    private Info info(String title, String description) {
        return new Info()
                .title(title)
                .version("0.0.1")
                .description(description);
    }
}

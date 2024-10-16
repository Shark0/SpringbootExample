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
    GroupedOpenApi tokenBucketExampleApis() {
        return GroupedOpenApi.builder()
                .group("token-bucket-example-apis")
                .displayName("Token Bucket Example Apis")
                .packagesToScan("org.shark.example.controller.bucket")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(info("Token Bucket Example APIS", "Token Bucket Example APIS")))
                .build();
    }

    private Info info(String title, String description) {
        return new Info()
                .title(title)
                .version("0.0.1")
                .description(description);
    }

}

package org.shark.example.config.swagger

import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun kafkaExampleApis(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("kafka-example-apis")
            .displayName("Kafka Example Apis")
            .packagesToScan("org.shark.example.controller.kafka")
            .addOpenApiCustomizer { openApi ->
                openApi.info(info("Kafka Example APIS", "Kafka Example APIS"))
            }
            .build()
    }

    private fun info(title: String, description: String): Info {
        return Info()
            .title(title)
            .version("0.0.1")
            .description(description)
    }
}

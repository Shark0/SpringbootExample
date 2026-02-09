package org.shark.example.config.swagger

import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SwaggerConfig {

    @Bean
    open fun rabbitMqExampleApis(): GroupedOpenApi {
        return GroupedOpenApi.builder()
                .group("rabbit-mq-example-apis")
                .displayName("RabbitMQ Example Apis")
                .packagesToScan("org.shark.example.controller.rabbit")
                .addOpenApiCustomizer { openApi ->
                    openApi.info(info("RabbitMQ Example APIS", "RabbitMQ Example APIS"))
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

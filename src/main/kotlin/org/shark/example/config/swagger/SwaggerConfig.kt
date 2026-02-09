package org.shark.example.config.swagger

import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SwaggerConfig {

    @Bean
    open fun mySqlExampleApis(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("mysql-example-apis")
            .displayName("Mysql Example Apis")
            .packagesToScan("org.shark.example.controller.mysql")
            .addOpenApiCustomizer { openApi ->
                openApi.info(info("Mysql Example APIS", "Mysql Example APIS"))
            }
            .build()
    }

    @Bean
    open fun userExampleApis(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("user-example-apis")
            .displayName("User Example Apis")
            .packagesToScan("org.shark.example.domain.user.inbound.web")
            .addOpenApiCustomizer { openApi ->
                openApi.info(info("User Example APIS", "User Example APIS"))
            }
            .build()
    }

    @Bean
    open fun jobExampleApis(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("job-example-apis")
            .displayName("Job Example Apis")
            .packagesToScan("org.shark.example.controller.quartz")
            .addOpenApiCustomizer { openApi ->
                openApi.info(info("Job Example APIS", "Job Example APIS"))
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

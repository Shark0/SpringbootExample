package org.shark.example.service.quartz.pojo

import io.swagger.v3.oas.annotations.media.Schema

data class CreateJobDto(
    var jobName: String? = null,
    var jobGroup: String? = null,
    @Schema(example = "0 0/5 * * * ?")
    var cronExpression: String? = null
)

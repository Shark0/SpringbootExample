package org.shark.example.service.quartz.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateJobDto {
    private String jobName;
    private String jobGroup;
    @Schema(example = "0 0/5 * * * ?")
    private String cronExpression;
}

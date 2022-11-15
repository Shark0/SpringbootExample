package org.shark.example.service.quartz.pojo;

import lombok.Data;

@Data
public class CreateJobDto {
    private String jobName;
    private String jobGroup;
    private String cronExpression;
}

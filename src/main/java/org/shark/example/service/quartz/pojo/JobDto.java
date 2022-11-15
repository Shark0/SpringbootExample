package org.shark.example.service.quartz.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class JobDto {
    private String cronExpression;
    private String jobClassName;
    private String triggerGroupName;
    private String triggerName;
    private String jobGroupName;
    private String jobName;
    private Date nextFireTime;
    private Date previousFireTime;
    private Date startTime;
    private String timeZone;
    private String status;
}

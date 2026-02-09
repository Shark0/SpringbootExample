package org.shark.example.service.quartz.pojo

import java.util.Date

data class JobDto(
    var cronExpression: String? = null,
    var jobClassName: String? = null,
    var triggerGroupName: String? = null,
    var triggerName: String? = null,
    var jobGroupName: String? = null,
    var jobName: String? = null,
    var nextFireTime: Date? = null,
    var previousFireTime: Date? = null,
    var startTime: Date? = null,
    var timeZone: String? = null,
    var status: String? = null
)

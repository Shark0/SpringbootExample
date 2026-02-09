package org.shark.example.service.quartz

import org.quartz.JobKey
import org.quartz.Scheduler
import org.quartz.SchedulerException
import org.quartz.TriggerKey
import org.shark.example.service.base.pojo.ResponseDto
import org.springframework.stereotype.Service

@Service
class DeleteJobService(
    private val scheduler: Scheduler
) {
    fun start(jobName: String, jobGroupName: String): ResponseDto<Void> {
        try {
            val key = TriggerKey.triggerKey(jobName, jobGroupName)
            scheduler.pauseTrigger(key)
            scheduler.unscheduleJob(key)
            scheduler.deleteJob(JobKey(jobName, jobGroupName))
        } catch (e: SchedulerException) {
            throw RuntimeException(e)
        }

        return ResponseDto.builder<Void>()
            .status(true).build()
    }
}

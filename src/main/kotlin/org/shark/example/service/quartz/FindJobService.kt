package org.shark.example.service.quartz

import org.quartz.*
import org.quartz.impl.matchers.GroupMatcher
import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.quartz.pojo.JobDto
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class FindJobService(
    private val scheduler: Scheduler
) {
    fun start(): ResponseDto<List<JobDto>> {
        val matcher = GroupMatcher.anyJobGroup()
        val jobList = ArrayList<JobDto>()
        try {
            val jobKeys = scheduler.getJobKeys(matcher)
            for (jobKey in jobKeys) {
                val triggers = scheduler.getTriggersOfJob(jobKey)
                for (trigger in triggers) {
                    val jobDetails = JobDto()
                    if (trigger is CronTrigger) {
                        jobDetails.cronExpression = trigger.cronExpression
                        jobDetails.timeZone = trigger.timeZone.displayName
                    }
                    jobDetails.triggerGroupName = trigger.key.name
                    jobDetails.triggerName = trigger.key.group
                    jobDetails.jobGroupName = jobKey.group
                    jobDetails.jobName = jobKey.name
                    jobDetails.startTime = trigger.startTime
                    jobDetails.jobClassName = scheduler.getJobDetail(jobKey).jobClass.name
                    jobDetails.nextFireTime = trigger.nextFireTime
                    jobDetails.previousFireTime = trigger.previousFireTime
                    jobDetails.status = scheduler.getTriggerState(trigger.key).name
                    jobList.add(jobDetails)
                }
            }
        } catch (e: SchedulerException) {
            throw RuntimeException(e)
        }

        return ResponseDto.builder<List<JobDto>>().status(true).data(jobList).build()
    }
}

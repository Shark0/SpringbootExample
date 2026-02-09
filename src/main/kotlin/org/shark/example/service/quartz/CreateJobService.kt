package org.shark.example.service.quartz

import org.quartz.*
import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.quartz.pojo.CreateJobDto
import org.springframework.stereotype.Service

@Service
class CreateJobService(
    private val scheduler: Scheduler
) {
    fun start(createJobDto: CreateJobDto): ResponseDto<Void> {
        val jobDetail = JobBuilder.newJob(ExampleJob::class.java)
            .withIdentity(createJobDto.jobName, createJobDto.jobGroup).build()

        val trigger = TriggerBuilder.newTrigger()
            .withIdentity(createJobDto.jobName, createJobDto.jobGroup)
            .startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND))
            .withSchedule(CronScheduleBuilder.cronSchedule(createJobDto.cronExpression)).startNow().build()

        try {
            scheduler.scheduleJob(jobDetail, trigger)
            if (!scheduler.isShutdown) {
                scheduler.start()
            }
        } catch (e: SchedulerException) {
            throw RuntimeException(e)
        }

        return ResponseDto.builder<Void>().status(true).build()
    }
}

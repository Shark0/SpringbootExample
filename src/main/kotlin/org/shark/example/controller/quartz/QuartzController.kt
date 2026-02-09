package org.shark.example.controller.quartz

import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.quartz.CreateJobService
import org.shark.example.service.quartz.DeleteJobService
import org.shark.example.service.quartz.FindJobService
import org.shark.example.service.quartz.pojo.CreateJobDto
import org.shark.example.service.quartz.pojo.JobDto
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/quartz")
class QuartzController(
    private val createJobService: CreateJobService,
    private val deleteJobService: DeleteJobService,
    private val findJobService: FindJobService
) {
    private val log = LoggerFactory.getLogger(QuartzController::class.java)

    @PostMapping
    fun createJob(@RequestBody createJobDto: CreateJobDto): ResponseDto<Void> {
        return createJobService.start(createJobDto)
    }

    @DeleteMapping
    fun deleteJob(@RequestParam("jobName") jobName: String, @RequestParam("jobGroup") jobGroup: String): ResponseDto<Void> {
        return deleteJobService.start(jobName, jobGroup)
    }

    @GetMapping
    fun findJob(): ResponseDto<List<JobDto>> {
        return findJobService.start()
    }
}

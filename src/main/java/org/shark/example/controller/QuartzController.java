package org.shark.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.quartz.CreateJobService;
import org.shark.example.service.quartz.DeleteJobService;
import org.shark.example.service.quartz.FindJobService;
import org.shark.example.service.quartz.pojo.CreateJobDto;
import org.shark.example.service.quartz.pojo.JobDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quartz")
@Slf4j
public class QuartzController {

    private final CreateJobService createJobService;
    @PostMapping
    public ResponseDto<Void> createJob(@RequestBody CreateJobDto createJobDto) {
        return createJobService.start(createJobDto);
    }

    private final DeleteJobService deleteJobService;

    @DeleteMapping
    public ResponseDto<Void> deleteJob(@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup) {
        return deleteJobService.start(jobName, jobGroup);
    }

    private final FindJobService findJobService;

    @GetMapping
    public ResponseDto<List<JobDto>> findJob() {
        return findJobService.start();
    }
}

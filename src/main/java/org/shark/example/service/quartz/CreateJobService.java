package org.shark.example.service.quartz;

import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.quartz.pojo.CreateJobDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateJobService {

    private final Scheduler scheduler;

    public ResponseDto<Void> start(CreateJobDto createJobDto) {
        JobDetail jobDetail = JobBuilder.newJob(ExampleJob.class).
                withIdentity(createJobDto.getJobName(), createJobDto.getJobGroup()).build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(createJobDto.getJobName(), createJobDto.getJobGroup())
                .startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND))
                .withSchedule(CronScheduleBuilder.cronSchedule(createJobDto.getCronExpression())).startNow().build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

        return ResponseDto.<Void>builder().status(1).build();
    }
}

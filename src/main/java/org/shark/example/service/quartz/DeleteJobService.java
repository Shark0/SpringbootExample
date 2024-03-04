package org.shark.example.service.quartz;

import lombok.RequiredArgsConstructor;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.shark.example.service.base.pojo.ResponseDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteJobService {

    private final Scheduler scheduler;

    public ResponseDto<Void> start(String jobName, String jobGroupName) {
        try {
            TriggerKey key = TriggerKey.triggerKey(jobName, jobGroupName);
            scheduler.pauseTrigger(key);
            scheduler.unscheduleJob(key);
            scheduler.deleteJob(new JobKey(jobName, jobGroupName));
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

        return ResponseDto.<Void>builder()
                .status(true).build();
    }
}

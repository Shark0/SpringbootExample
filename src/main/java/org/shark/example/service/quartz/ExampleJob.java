package org.shark.example.service.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class ExampleJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) {
        context.getJobDetail().getJobDataMap().forEach(
                (k, v) -> log.info("param, key:{}, value:{}", k, v)
        );
        log.info("current time: " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
package org.shark.example.service.quartz

import org.quartz.JobExecutionContext
import org.slf4j.LoggerFactory
import org.springframework.scheduling.quartz.QuartzJobBean
import java.text.SimpleDateFormat
import java.util.*

class ExampleJob : QuartzJobBean() {

    private val log = LoggerFactory.getLogger(ExampleJob::class.java)

    override fun executeInternal(context: JobExecutionContext) {
        context.jobDetail.jobDataMap.forEach { k, v ->
            log.info("param, key:{}, value:{}", k, v)
        }
        log.info("current time: " + SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date()))
    }
}

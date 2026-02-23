package org.shark.example.config.event

import org.slf4j.MDC
import org.springframework.core.task.TaskDecorator

class AsyncTaskDecorator : TaskDecorator {
    override fun decorate(runnable: Runnable): Runnable {
        val map = MDC.getCopyOfContextMap()
        return Runnable {
            try {
                if (map != null) {
                    MDC.setContextMap(map)
                }
                runnable.run()
            } finally {
                MDC.clear()
            }
        }
    }
}

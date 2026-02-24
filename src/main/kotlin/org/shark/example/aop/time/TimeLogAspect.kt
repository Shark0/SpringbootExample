package org.shark.example.aop.time

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class TimeLogAspect {

    private val log = LoggerFactory.getLogger(TimeLogAspect::class.java)

    @Around("execution(* org.shark.example.controller.i18n.*.*(..))")
    @Throws(Throwable::class)
    fun logExecutionTime(joinPoint: ProceedingJoinPoint): Any? {
        val start = System.currentTimeMillis()
        val proceed = joinPoint.proceed()
        val executionTime = System.currentTimeMillis() - start
        log.info("{} executed in {} ms", joinPoint.signature, executionTime)
        return proceed
    }
}

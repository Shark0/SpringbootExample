package org.shark.example.exception

import org.shark.example.service.base.pojo.ResponseDto
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionAdvice {

    private val log = LoggerFactory.getLogger(ExceptionAdvice::class.java)

    @ExceptionHandler(Exception::class)
    fun errorMessageHandler(e: Exception): ResponseDto<Void> {
        log.error(e.message, e)
        return ResponseDto(status = false, errorMessage = e.message)
    }
}

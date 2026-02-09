package org.shark.example.exception

import org.shark.example.service.base.pojo.ResponseDto
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionAdvice {

    private val log = LoggerFactory.getLogger(ExceptionAdvice::class.java)

    @ExceptionHandler(Exception::class)
    fun errorMessageHandler(e: Exception): ResponseDto<Void> {
        log.error(e.message, e)
        return ResponseDto.builder<Void>().status(false).errorMessage(e.message).build()
    }

    @ExceptionHandler(TooManyRequestException::class)
    fun tooManyRequestErrorMessageHandler(e: TooManyRequestException): ResponseEntity<String> {
        log.error(e.message, e)
        return ResponseEntity.status(429).body(e.message)
    }
}

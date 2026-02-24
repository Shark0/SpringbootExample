package org.shark.example.service.i18n

import org.shark.example.service.base.pojo.ResponseDto
import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import java.util.Locale

@Service
class GetI18nService(private val messageSource: MessageSource) {

    private val log = LoggerFactory.getLogger(GetI18nService::class.java)

    fun start(value1: String, value2: Int): ResponseDto<String> {
        log.info("Locale.getDefault() = {}", Locale.getDefault().toString())
        return ResponseDto(
            data = messageSource.getMessage("message1", arrayOf(value1, value2), Locale.getDefault()),
            status = true
        )
    }
}

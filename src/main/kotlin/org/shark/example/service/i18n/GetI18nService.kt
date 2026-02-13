package org.shark.example.service.i18n

import io.github.oshai.kotlinlogging.KotlinLogging
import org.shark.example.service.base.pojo.ResponseDto
import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import java.util.Locale

private val log = KotlinLogging.logger {}

@Service
class GetI18nService(
    private val messageSource: MessageSource
) {
    // 優化：直接使用更具慣用性的日誌宣告方式


    fun start(value1: String, value2: Int): ResponseDto<String> {
        val locale = Locale.getDefault()

        log.info { "Locale.getDefault() = $locale" }

        return ResponseDto(
            data = messageSource.getMessage("message1", arrayOf<Any>(value1, value2), locale),
            status = true
        )
    }
}
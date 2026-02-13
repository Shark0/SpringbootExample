package org.shark.example.service.file

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

@Service
class SaveFileApiService {
    private val log = LoggerFactory.getLogger(SaveFileApiService::class.java)

    fun start(file: MultipartFile) {
        log.info("file name is {}", file.originalFilename)

        try {
            val targetFile = File("file/" + file.originalFilename)
            val parent = targetFile.parentFile
            if (parent != null && !parent.exists()) {
                parent.mkdirs()
            }
            
            FileOutputStream(targetFile).use { outputStream ->
                outputStream.write(file.bytes)
            }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}

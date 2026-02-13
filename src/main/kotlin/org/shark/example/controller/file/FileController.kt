package org.shark.example.controller.file

import org.shark.example.service.file.SaveFileApiService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("file")
class FileController(
    private val saveFileApiService: SaveFileApiService
) {

    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun save(@RequestPart file: MultipartFile) {
        saveFileApiService.start(file)
    }
}

package org.shark.example.controller.file;

import lombok.RequiredArgsConstructor;
import org.shark.example.service.file.SaveFileApiService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
@RequiredArgsConstructor
public class FileController {

    private final SaveFileApiService saveFileApiService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void save(@RequestPart MultipartFile file) {
        saveFileApiService.start(file);
    }
}

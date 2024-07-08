package org.shark.example.service.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Slf4j
@Service
public class SaveFileApiService {

    public void start(MultipartFile file) {
        log.info("file name is {}", file.getOriginalFilename());

        try(OutputStream outputStream = new FileOutputStream("file/" + file.getOriginalFilename())) {
            outputStream.write(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.shark.example.service.base.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@Slf4j
public class AsyncTask1 {

    @Async("taskExecutor1")
    public CompletableFuture<String> start(String value) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//        log.info("time = " + time + ", value = " + value);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.completedFuture("AsyncTask1 value = " + value);
    }
}

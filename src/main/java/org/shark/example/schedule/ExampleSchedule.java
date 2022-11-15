package org.shark.example.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Component
public class ExampleSchedule {


//    @Qualifier("taskExecutor1")
//    private final Executor taskExecutor1;
//
//    private final AsyncTask1 asyncTask1;
//
//    @Scheduled(initialDelay = 1000, fixedRate = 1000)
//    public void example1() {
//        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
////        log.info("time = " + time);
//        List<CompletableFuture<String>> resultList = new ArrayList<>();
//        for(int i = 0; i < 20000; i ++) {
//            int queueSize = ((ThreadPoolTaskExecutor) taskExecutor1).getThreadPoolExecutor().getQueue().size();
//            long activeCount = ((ThreadPoolTaskExecutor) taskExecutor1).getThreadPoolExecutor().getActiveCount();
////            log.info("i = " + i + ", queueSize = " + queueSize + ", activeCount = " + activeCount);
//            if(queueSize >= 16) {
//                continue;
//            }
//            CompletableFuture<String> result = asyncTask1.start("test" + i);
//            resultList.add(result);
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        CompletableFuture.allOf(resultList.toArray(new CompletableFuture[0])).join();
//    }


    @Async
    @Scheduled(cron = "*/5 * * * * *")
    public void example2() {
        log.info("start time: " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void example3() {
        log.info("start time: " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

package org.shark.example.service.cassandra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.datasource.cassandra.pojo.MessageDo;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class SaveMessageTask {

    private final CassandraTemplate cassandraTemplate;

    @Async
    public CompletableFuture<Boolean> start(List<MessageDo> messageList) {
        long saveStartTime = System.currentTimeMillis();
        try {
            cassandraTemplate.batchOps().insert(messageList).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long saveEndTime = System.currentTimeMillis();
        log.info("save time: {} ms", saveEndTime - saveStartTime);
        return CompletableFuture.completedFuture(true);
    }

}

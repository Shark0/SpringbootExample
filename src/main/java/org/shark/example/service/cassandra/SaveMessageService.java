package org.shark.example.service.cassandra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.datasource.cassandra.MessageRepository;
import org.shark.example.datasource.cassandra.pojo.MessageDo;
import org.shark.example.datasource.cassandra.pojo.MessageKeyDo;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class SaveMessageService {

    //    private final MessageRepository messageRepository;
    private final CassandraTemplate cassandraTemplate;

    public void saveMessage() {
        long userCount = 100;
        long messageCount = 10;

        List<MessageDo> messageList = new ArrayList<>();
        for (long i = 0; i < userCount; i++) {
            for (long j = 0; j < messageCount; j++) {
                MessageDo messageDo = new MessageDo();
                MessageKeyDo messageKeyDo = new MessageKeyDo();
                messageKeyDo.setUserId(i);
                messageKeyDo.setUserService("CUSTOMER");
                messageKeyDo.setItemId(j);
                messageDo.setMessageKey(messageKeyDo);
                messageDo.setTime(new Date());
                messageList.add(messageDo);
            }
        }
        long startTime = System.currentTimeMillis();


        cassandraTemplate.batchOps().insert(messageList).execute();

        long endTime = System.currentTimeMillis();
        log.info("total save time: {} ms", (endTime - startTime));
    }
}

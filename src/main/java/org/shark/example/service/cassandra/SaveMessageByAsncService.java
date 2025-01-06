package org.shark.example.service.cassandra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.datasource.cassandra.pojo.MessageDo;
import org.shark.example.datasource.cassandra.pojo.MessageKeyDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class SaveMessageByAsncService {

    private final SaveMessageTask saveMessageTask;

    public void saveMessage() {
        long userCount = 100;
        long messageCount = 100;
        List<CompletableFuture<Boolean>> resultList = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        List<MessageDo> messageList = new ArrayList<>();
        for (long i = 0; i < userCount; i++) {
            for (long j = 0; j < messageCount; j++) {
                MessageDo messageDo = new MessageDo();
                MessageKeyDo messageKeyDo = new MessageKeyDo();
                messageKeyDo.setUserId(i);
                messageKeyDo.setUserService("CHIT_CHAT");
                messageKeyDo.setItemId(j);
                messageDo.setMessageKey(messageKeyDo);
                messageDo.setTime(new Date());
                messageList.add(messageDo);
                if(messageList.size() == 100){
                    resultList.add(saveMessageTask.start(messageList));
                    messageList = new ArrayList<>();
                }
            }
        }
        CompletableFuture.allOf(resultList.toArray(new CompletableFuture[0])).join();
        long endTime = System.currentTimeMillis();
        log.info("total save time: {} ms", (endTime - startTime));
    }
}

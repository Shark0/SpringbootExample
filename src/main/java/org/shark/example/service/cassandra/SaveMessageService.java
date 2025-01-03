package org.shark.example.service.cassandra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shark.example.datasource.cassandra.MessageRepository;
import org.shark.example.datasource.cassandra.pojo.MessageDo;
import org.shark.example.datasource.cassandra.pojo.MessageKeyDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SaveMessageService {

    private final MessageRepository messageRepository;

    public void saveMessage() {
        List<MessageDo> messageList = new ArrayList<>();
        long userCount = 10;
        long messageCount = 1000;

        long generateStartTime = System.currentTimeMillis();
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
            }
        }
        long generateEndTime = System.currentTimeMillis();
        log.info("generate time: {} ms", generateEndTime - generateStartTime);

        long saveStartTime = System.currentTimeMillis();
        messageRepository.saveAll(messageList);
        long saveEndTime = System.currentTimeMillis();
        log.info("save time: {} ms", saveEndTime - saveStartTime);
    }
}

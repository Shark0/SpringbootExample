package org.shark.example.service.cassandra;

import lombok.RequiredArgsConstructor;
import org.shark.example.datasource.cassandra.MessageRepository;
import org.shark.example.datasource.cassandra.pojo.MessageDo;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetMessageListService {

    private final MessageRepository messageRepository;

    public List<MessageDo> getAccountList() {
        return messageRepository.findAll();
    }

}

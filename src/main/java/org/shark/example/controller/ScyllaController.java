package org.shark.example.controller;

import lombok.RequiredArgsConstructor;
import org.shark.example.datasource.cassandra.pojo.MessageDo;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.cassandra.GetMessageListService;
import org.shark.example.service.cassandra.SaveMessageByAsncService;
import org.shark.example.service.cassandra.SaveMessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/scylla")
@RestController
public class ScyllaController {

    private final SaveMessageService saveMessageService;
    @PostMapping
    public ResponseDto<Void> saveMessage() {
        saveMessageService.saveMessage();
        return ResponseDto.<Void>builder().status(true).build();
    }

    private final SaveMessageByAsncService saveMessageByAsncService;

    @PostMapping("async")
    public ResponseDto<Void> saveMessageAsync() {
        saveMessageByAsncService.saveMessage();
        return ResponseDto.<Void>builder().status(true).build();
    }

    private final GetMessageListService getMessageListService;

    @GetMapping
    public ResponseDto<List<MessageDo>> getAccount() {
        List<MessageDo> messageDoList = getMessageListService.getAccountList();
        return ResponseDto.<List<MessageDo>>builder().data(messageDoList).status(true).build();
    }
}

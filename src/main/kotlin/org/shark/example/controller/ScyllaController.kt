package org.shark.example.controller

import org.shark.example.datasource.cassandra.pojo.MessageDo
import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.cassandra.GetMessageListService
import org.shark.example.service.cassandra.SaveMessageByAsyncService
import org.shark.example.service.cassandra.SaveMessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/scylla")
@RestController
class ScyllaController(
    private val saveMessageService: SaveMessageService,
    private val saveMessageByAsyncService: SaveMessageByAsyncService,
    private val getMessageListService: GetMessageListService
) {

    @PostMapping
    fun saveMessage(): ResponseDto<Void> {
        saveMessageService.saveMessage()
        return ResponseDto(status = true)
    }

    @PostMapping("async")
    fun saveMessageAsync(): ResponseDto<Void> {
        saveMessageByAsyncService.saveMessage()
        return ResponseDto(status = true)
    }

    @GetMapping
    fun getAccount(): ResponseDto<List<MessageDo>> {
        val messageDoList = getMessageListService.getAccountList()
        return ResponseDto(data = messageDoList, status = true)
    }
}

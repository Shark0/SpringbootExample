package org.shark.example.controller.mysql

import org.shark.example.controller.mysql.pojo.JsonInnerJoinDto
import org.shark.example.dao.repository.pojo.TaskDo
import org.shark.example.dao.repository.pojo.TaskHistoryDo
import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.mysql.*
import org.shark.example.service.mysql.pojo.CreateJsonExampleDto
import org.shark.example.service.mysql.pojo.CreateJsonJoinExampleDto
import org.shark.example.service.mysql.pojo.CreateTaskDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mysql")
class MysqlController(
    private val createTaskService: CreateTaskService,
    private val findTaskService: FindTaskService,
    private val findTaskHistoryService: FindTaskHistoryService,
    private val createJsonExampleService: CreateJsonExampleService,
    private val createJsonJoinExampleService: CreateJsonJoinExampleService,
    private val findJsonInnerJoinResultService: FindJsonInnerJoinResultService
) {

    @PostMapping("task")
    fun createDateTime(@RequestBody createTaskDto: CreateTaskDto): ResponseDto<Void> {
        createTaskService.start(createTaskDto)
        return ResponseDto.builder<Void>().status(true).build()
    }

    @GetMapping("task")
    fun findTask(
        @RequestParam page: Int, @RequestParam size: Int
    ): ResponseDto<List<TaskDo>> {
        val taskDoList = findTaskService.start(page, size)
        return ResponseDto.builder<List<TaskDo>>().status(true).data(taskDoList).build()
    }

    @GetMapping("task-history")
    fun findTaskHistory(
        @RequestParam page: Int, @RequestParam size: Int
    ): ResponseDto<List<TaskHistoryDo>> {
        val taskHistoryDoList = findTaskHistoryService.start(page, size)
        return ResponseDto.builder<List<TaskHistoryDo>>().status(true).data(taskHistoryDoList).build()
    }

    @PostMapping("json-example")
    fun createJsonExample(@RequestBody createJsonExampleDto: CreateJsonExampleDto): ResponseDto<Void> {
        createJsonExampleService.createJsonExample(createJsonExampleDto)
        return ResponseDto.builder<Void>().status(true).build()
    }

    @PostMapping("json-join-example")
    fun createJsonExample(@RequestBody createJsonJoinExampleDto: CreateJsonJoinExampleDto): ResponseDto<Void> {
        createJsonJoinExampleService.createJsonExample(createJsonJoinExampleDto)
        return ResponseDto.builder<Void>().status(true).build()
    }

    @GetMapping("json-inner-join")
    fun findJsonInnerJoin(): ResponseDto<List<JsonInnerJoinDto>> {
        val list = findJsonInnerJoinResultService.start()
        return ResponseDto.builder<List<JsonInnerJoinDto>>().data(list).status(true).build()
    }
}

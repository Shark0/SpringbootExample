package org.shark.example.controller

import jakarta.validation.Valid
import org.shark.example.datasource.cassandra.pojo.AccountDo
import org.shark.example.service.base.pojo.ResponseDto
import org.shark.example.service.cassandra.GetAccountListService
import org.shark.example.service.cassandra.SaveAccountService
import org.shark.example.service.cassandra.pojo.SaveAccountDto
import org.springframework.web.bind.annotation.*

@RequestMapping("/cassandra")
@RestController
class CassandraController(
    private val saveAccountService: SaveAccountService,
    private val getAccountListService: GetAccountListService
) {

    @PostMapping
    fun saveAccount(@RequestBody @Valid saveAccountDto: SaveAccountDto): ResponseDto<AccountDo> {
        val accountDo = saveAccountService.saveAccount(saveAccountDto)
        return ResponseDto(status = true, data = accountDo)
    }

    @GetMapping
    fun getAccount(): ResponseDto<List<AccountDo>> {
        val accountDoList = getAccountListService.getAccountList()
        return ResponseDto(status = true, data = accountDoList)
    }
}
